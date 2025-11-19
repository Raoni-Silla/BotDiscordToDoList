package br.com.raoni.BotDiscordToDoList.Controller;

import br.com.raoni.BotDiscordToDoList.model.Task;
import br.com.raoni.BotDiscordToDoList.service.TaskService;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BotListener extends ListenerAdapter {
    @Autowired
    TaskService service;


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        Object objeto = event.getAuthor().getName();

        if (event.getMessage().getContentRaw().equalsIgnoreCase("!todo")){
            //pega o conteudo da mensagem enviada
            event.getChannel().sendMessage("chamado ouvido mestre " + objeto).queue();
            //pego o eveento que ocorreu, vejo em qual canal ele ocorreu, e retorno uma mensagem pong (queue envia a mensagem) se for igual a ping
        }

        if (event.getMessage().getContentRaw().startsWith("!add ")){

            String description = event.getMessage().getContentRaw().substring(5);
            String id = event.getMessage().getAuthor().getId();
            service.createTask(description,id);

            event.getChannel().sendMessage("tarefa criada com sucesso").queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("!list")){

            String description = event.getMessage().getContentRaw().substring(5);

            String id = event.getMessage().getAuthor().getId();

            List <Task> tasksFind = service.getListTasksByUser(id);

            if(tasksFind.isEmpty()){
                event.getChannel().sendMessage("📭 Você não tem tarefas pendentes!").queue();
            }

            StringBuilder builder = new StringBuilder();

            for (Task t : tasksFind) {

                if (t.isCompleted()) {
                    builder.append("✅ ~~")
                            .append("**").append(t.getId()).append("** - ")
                            .append(t.getDescription())
                            .append("~~") // <--- Importante: Fechar o risco aqui!
                            .append("\n");
                } else {
                    builder.append("⬜ ")
                            .append("**").append(t.getId()).append("** - ")
                            .append(t.getDescription())
                            .append("\n");
                }

            }

            event.getChannel().sendMessage(builder.toString()).queue();
        }

        if (event.getMessage().getContentRaw().startsWith("!remove ")){
            try {

                Long idTask = Long.parseLong(event.getMessage().getContentRaw().substring(8));
                service.deleteTasksById(idTask);
                event.getChannel().sendMessage("tarefa removida com sucesso").queue();

            }catch (NumberFormatException e){

                event.getChannel().sendMessage("Digite um id (numerico) a ser excluido" + e.getMessage()).queue();

            }catch (Exception e){

                event.getChannel().sendMessage(e.getMessage()).queue();

            }
        }

        if (event.getMessage().getContentRaw().startsWith("!done ")){
            try {

                Long idTask = Long.parseLong(event.getMessage().getContentRaw().substring(6));
                boolean done = service.taskCompleted(idTask);

                if (done){
                    event.getChannel().sendMessage("tarefa completa com sucesso").queue();
                }else {
                    event.getChannel().sendMessage("tarefa não encontrada").queue();
                }


            }catch (NumberFormatException e){

                event.getChannel().sendMessage("Digite um id (numerico) a ser buscado, ERRO: " + e.getMessage()).queue();

            }catch (Exception e){

                event.getChannel().sendMessage(e.getMessage()).queue();

            }
        }


    }
}
