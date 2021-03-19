package cm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LucanPeterTestTask3 {

    // Section One --------------- Valid Input Tests for Rate(...)

    //test 1
    //Partition Tested: of kind: kind == STAFF || STUDENT || MANAGEMENT || VISITOR
    @Test
    public void test1() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        CarParkKind kind2 = CarParkKind.STUDENT;
        Rate rate2 = new Rate(kind2, normalRate, reducedRate, reducedPeriods, normalPeriods);

        CarParkKind kind3 = CarParkKind.MANAGEMENT;
        Rate rate3 = new Rate(kind3, normalRate, reducedRate, reducedPeriods, normalPeriods);

        CarParkKind kind4 = CarParkKind.VISITOR;
        Rate rate4 = new Rate(kind4, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 2
    //Partition Tested: of normalRate: normalRate > 0
    @Test
    public void test2() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 3
    //Partition Tested: of normalRate: normalRate > reducedRate
    @Test
    public void test3() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 4
    //Partition Tested: of reducedRate: reducedRate > 0
    @Test
    public void test4() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 5
    //Partition Tested: of reducedPeriods: reducedPeriods !overlap normalPeriods
    @Test
    public void test5() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(13, 14));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 6
    //Partition Tested: of reducedPeriods: reducedPeriods !overlap reducedPeriods
    @Test
    public void test6() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(13, 14));
        reducedPeriods.add(new Period(14, 15));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 7
    //Partition Tested: of normalPeriods: normalPeriods !overlap normalPeriods
    @Test
    public void test7() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(11, 12));
        normalPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(13, 14));


        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    // Section Two --------------- Invalid Input Tests for Rate(...)


    //test 8
    //Partition Tested: of kind: kind == null
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test8() {
        CarParkKind kind = null;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 9
    //Partition Tested: of normalRate: normalRate < 0
    //expected output: IllegalArgumentException

    @Test
    public void test9() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 10
    //Partition Tested: of normalRate: normalRate < reducedRate
    //expected output: IllegalArgumentException

    @Test
    public void test10() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 11
    //Partition Tested: of normalRate: normalRate == null
    //expected output: IllegalArgumentException

    @Test
    public void test11() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 12
    //Partition Tested: of normalRate: normalRate == reducedRate
    //expected output: IllegalArgumentException

    @Test
    public void test12() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 13
    //Partition Tested: of reducedRate: reducedRate < 0
    //expected output: IllegalArgumentException

    @Test
    public void test13() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 14
    //Partition Tested: of reducedRate: reducedRate == null
    //expected output: IllegalArgumentException

    @Test
    public void test14() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = null;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 15
    //Partition Tested: of reducedPeriods: reducedPeriods == null
    //expected output: IllegalArgumentException

    @Test
    public void test15() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods = null;

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 16
    //Partition Tested: of reducedPeriods: reducedPeriods overlap normalPeriods
    //expected output: IllegalArgumentException

    @Test
    public void test16() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(12,13));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 17
    //Partition Tested: of reducedPeriods: reducedPeriods overlaps reducedPeriods
    //expected output: IllegalArgumentException

    @Test
    public void test17() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(13,14));
        reducedPeriods.add(new Period(13,14));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 18
    //Partition Tested: of normalPeriods: normalPeriods == null
    //expected output: IllegalArgumentException

    @Test
    public void test18() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods = null;
        reducedPeriods.add(new Period(13,14));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 19
    //Partition Tested: of normalPeriods: normalPeriods overlaps normalPeriods
    //expected output: IllegalArgumentException

    @Test
    public void test19() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12,13));
        normalPeriods.add(new Period(12,13));
        reducedPeriods.add(new Period(10,12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    // Section Three --------------- Tests for Calculate()

    //test 20
    //Partition Tested: of periodStay: periodStay == null
    //expected output: IllegalArgumentException
    @Test
    public void test20() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(null);
    }

    //test 21
    //Partition Tested: of periodStay: startHour < endHour
    @Test
    public void test21() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(10,12));
    }

    //test 22
    //Partition Tested: of periodStay: startHour == endHour
    //expected output: IllegalArgumentException
    @Test
    public void test22() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(12,12));
    }

    //test 23
    //Partition Tested: of periodStay: startHour > endHour
    //expected output: IllegalArgumentException
    @Test
    public void test23() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(12,10));
    }

    //test 24
    //Partition Tested: of periodStay: startHour < 0
    //expected output: IllegalArgumentException
    @Test
    public void test24() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(-1,10));
    }

    //test 25
    //Partition Tested: of periodStay: startHour > 24
    //expected output: IllegalArgumentException
    @Test
    public void test25() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(25, 10));
    }

    //test 26
    //Partition Tested: of periodStay: endHour < 0
    //expected output: IllegalArgumentException
    @Test
    public void test26() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(12, -1));
    }

    //test 27
    //Partition Tested: of periodStay: startHour > 24
    //expected output: IllegalArgumentException
    @Test
    public void test27() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(9, 10));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(12, 25));
    }

    //test 28
    //Partition Tested: of periodStay: normalRate
    //expected output: 10
    @Test
    public void test28() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(10, 12));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertEquals(new BigDecimal("10"), rate.calculate(new Period(12,14)));
    }

    //test 29
    //Partition Tested: of periodStay: reducedRate
    //expected output: 4
    @Test
    public void test29() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(14, 16));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertEquals(new BigDecimal("4"), rate.calculate(new Period(14,16)));
    }

//---------------Task1 Tests End Here-----------------------------------------------------------------------------------------------------------------
//====================================================================================================================================================
//---------------Task2 Tests Begin Here---------------------------------------------------------------------------------------------------------------

    //test 1
    //Partition Tested: Overlapping Normal Periods
    @Test
    public void taskTwoTest1() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(10, 11));
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 13));

        reducedPeriods.add(new Period(14, 15));
        reducedPeriods.add(new Period(15, 16));
        reducedPeriods.add(new Period(16, 17));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    //test 2
    //Partition Tested: Reduced and Normal Peroids overlap
    @Test
    public void taskTwoTest2() {
        exception.expect(IllegalArgumentException.class);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(10, 11));
        normalPeriods.add(new Period(11, 12));
        normalPeriods.add(new Period(12, 13));

        reducedPeriods.add(new Period(10, 11));
        reducedPeriods.add(new Period(11, 12));
        reducedPeriods.add(new Period(12, 13));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

//---------------Task2 Tests End Here-----------------------------------------------------------------------------------------------------------------
//====================================================================================================================================================
//---------------Task3 Tests Begin Here---------------------------------------------------------------------------------------------------------------

    //test 1
    //kind == VISITOR
    //Period < 8.00
    //Expected Result: free
    @Test
    public void taskThreeTest1() {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(0, 8));
        reducedPeriods.add(new Period(9, 18));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period stay = new Period(1,3);
        assertEquals(new BigDecimal(0), rate.calculate(stay));
    }

    //test 2
    //kind == VISITOR
    //Period == 8.00
    //Expected Result: free
    @Test
    public void taskThreeTest2() {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(0, 8));
        reducedPeriods.add(new Period(9, 18));

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period stay = new Period(0,7);
        assertEquals(new BigDecimal(0), rate.calculate(stay));
    }
}