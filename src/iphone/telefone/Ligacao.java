package iphone.telefone;

import java.util.Date;

public class Ligacao {
    private final Contato contato;
    private boolean atendida;
    private final Date startDate;
    private Date endDate;
    private boolean finalizada = false;

    public Ligacao(Contato contato) {
        this.contato = contato;
        startDate = new Date();
    }

    public Contato getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "Ligacao{" +
                " contato=" + contato + ",\n" +
                " atendida=" + atendida + ",\n" +
                " startDate=" + startDate + ",\n" +
                " endDate=" + endDate + "\n" +
                '}';
    }

    public void atender() {
        if(!finalizada || !atendida) {
            System.out.println("Ligação Atendida de " + contato.getNome());
            atendida = true;
        }
    }

    public void recusar() {
        if(!finalizada || !atendida){
            System.out.println("Ligação Recusada de " + contato.getNome());
            atendida = false;
            finalizada = true;
            endDate = startDate;
        }
    }

    public void finalizar() {
        if(!finalizada && atendida) {
            System.out.println("Ligação Finalizada de " + contato.getNome());
            endDate = new Date();
            finalizada = true;
        }
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public long getDuracao() {
        if(endDate == null)
            return 0;
        return endDate.getTime() - startDate.getTime();
    }

    public String getDuracaoString() {
        long duracao = getDuracao();
        long segundos = duracao / 1000;
        long minutos = segundos / 60;
        segundos = segundos % 60;
        long horas = minutos / 60;
        minutos = minutos % 60;
        return horas + "h " + minutos + "m " + segundos + "s";
    }
}
