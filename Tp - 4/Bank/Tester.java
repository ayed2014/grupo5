package Bank;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Paca on 4/11/14.
 */
public class Tester {
    public static void main(String[] args) {
        BankA testBankA = new BankA();
        BankB testBankB = new BankB();

        testBankA.starDay();
        System.out.println("BANK A: ");
        System.out.println(testBankA.getPeopleAttendedUntil15());
        System.out.println(testBankA.getPeopleAttended());
        System.out.println(testBankA.getFreeTimeWindow1());
        System.out.println(testBankA.getFreeTimeWindow2());
        System.out.println(testBankA.getFreeTimeWindow3());


        testBankB.starDay();
        System.out.println("\nBANK B: ");
        System.out.println(testBankB.getPeopleAttendedUntil15());
        System.out.println(testBankB.getPeopleAttended());
        System.out.println(testBankB.getFreeTimeWindow1());
        System.out.println(testBankB.getFreeTimeWindow2());
        System.out.println(testBankB.getFreeTimeWindow3());
    }
}
