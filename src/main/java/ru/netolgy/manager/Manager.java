package ru.netolgy.manager;

import ru.netolgy.repository.Repository;
import ru.netolgy.ticket.Ticket;

import java.util.Arrays;

public class Manager {
    private Repository repo;// добавили репозиторий Билетов

    public Manager(Repository repo) { //конструкторы Манагера
        this.repo = repo;
    }

    public void add(Ticket ticket) {// метод добаления
        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length +1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];

                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }



    private boolean matches(ru.netolgy.ticket.Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }

        }
        return false;
    }

}