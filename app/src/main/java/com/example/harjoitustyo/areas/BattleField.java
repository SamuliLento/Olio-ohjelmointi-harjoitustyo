package com.example.harjoitustyo.areas;

import com.example.harjoitustyo.lutemons.Lutemon;

public class BattleField extends Storage {

    private static BattleField battleField = null;
    protected BattleField() {
        super("Battle Field");
    }

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new BattleField();
        }
        return battleField;
    }

    //Two Lutemons fight, winner gains experience and returns home, loser goes to graveyard
    public String fight(Lutemon lutemon1, Lutemon lutemon2) {

        String battleLog = "";
        Lutemon winner = lutemon1;
        Lutemon loser = lutemon2;

        while (lutemon1.getHitPoints() > 0 && lutemon2.getHitPoints() > 0) {
            battleLog = battleLog + lutemon1.printStats();
            battleLog = battleLog + lutemon2.printStats();
            lutemon1.defend(lutemon2.getAttack());
            battleLog = battleLog + lutemon2.getName() + " (" + lutemon2.getColor() + ") attacks " + lutemon1.getName() + " (" + lutemon1.getColor() + ")\n";

            if (lutemon1.getHitPoints() > 0) {
                battleLog = battleLog + lutemon1.getName() + " (" + lutemon1.getColor() + ") manages to escape death.\n";
                battleLog = battleLog + lutemon1.printStats();
                battleLog = battleLog + lutemon2.printStats();
                lutemon2.defend(lutemon1.getAttack());
                battleLog = battleLog + lutemon1.getName() + " (" + lutemon1.getColor() + ") attacks " + lutemon2.getName() + " (" + lutemon2.getColor() + ")\n";
                if (lutemon2.getHitPoints() > 0) {
                    battleLog = battleLog + lutemon2.getName() + " (" + lutemon2.getColor() + ") manages to escape death.\n";
                } else {
                    battleLog = battleLog + lutemon2.getName() + " (" + lutemon2.getColor() + ") gets killed.\n";
                    winner = lutemon1;
                    loser = lutemon2;
                }
            } else {
                battleLog = battleLog + lutemon1.getName() + " (" + lutemon1.getColor() + ") gets killed.\n";
                winner = lutemon2;
                loser = lutemon1;
            }
        }
        battleLog = battleLog + "The battle is over.";
        winner.heal();
        winner.setExperience(1);
        Home.getInstance().addLutemon(winner);
        Graveyard.getInstance().addLutemon(loser);
        BattleField.getInstance().removeLutemon(winner.getId());
        BattleField.getInstance().removeLutemon(loser.getId());

        return battleLog;
    }
}
