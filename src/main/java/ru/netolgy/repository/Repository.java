package ru.netolgy.repository;
import ru.netolgy.ticket.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];// создаем пустой репозиторий

    public void save(Ticket  ticket){// метод добавать продукт

        Ticket[] tmp = new Ticket[tickets.length +1]; // массив для добавления
        for (int i = 0; i < tickets.length; i++) { // счетчик
            tmp[i] = tickets[i]; // скопировать все эл-ты из старого в новый

        }
        tmp[tickets.length] = ticket;// в массив tmp в ячейку tickets.length добавляем заначение ячейки ticket
        tickets = tmp; // присвоить полю ticket новый массив
    }


    public Ticket[] findAll(){ //метод получать все сохраненные
        return tickets;
    }//метод хранить массив Продукт

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }



}
