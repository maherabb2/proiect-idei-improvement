package com.hipermarket;

import com.hipermarket.fisiere.CitireFisier;
import com.hipermarket.fisiere.ScriereFisier;
import com.hipermarket.meniuri.Meniu;
import com.hipermarket.meniuri.MeniuPrincipal;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File fisier = new File("database/input.txt");  // Asa nu - folositi constante pentru valori definite.
        CitireFisier citire = new CitireFisier(fisier);
        ScriereFisier scriere = new ScriereFisier(fisier);

        Meniu meniu = new MeniuPrincipal();
        while (true) {
            char c = citire.citireCaracter();

            if (c != 'x') {
                // Stergeti sau pastrati, doar ca sa se evidentieze mai bine in consola
                System.out.println("==================================");
                System.out.println("Am citit din fisier comanda: " + c);
                meniu.afisare();
                meniu = meniu.interpreteazaComanda(c);
                scriere.scrieCaracter('x');
                System.out.println("==================================");
            }
        }
    }
}
