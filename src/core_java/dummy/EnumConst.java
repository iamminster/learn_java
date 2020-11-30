package core_java.dummy;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class EnumConst {
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;
    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    public enum APPLE {FUJI, PIPPIN, GRANNY_SMITH}

    ;

    public enum ORANGE {NAVEL, TEMPLE, BLOOD}

    ;

    public enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS(4.869e+24, 6.052e6),
        EARTH(5.975e+24, 6.378e6),
        MARS(6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN(5.685e+26, 6.027e7),
        URANUS(8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);

        private final double mass;
        private final double radius;
        private final double surfaceGravity;

        // Universal gravitational constant in m^3 / kg s^2
        private static final double G = 6.67300E-11;

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / Math.pow(radius, 2);
        }

        public double mass() {
            return mass;
        }

        public double radius() {
            return radius;
        }

        public double surfaceGravity() {
            return surfaceGravity;
        }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity;
        }
    }


    public enum BadOperation {
        PLUS, MINUS, TIMES, DIVIDE;

        public double apply(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
            }
            throw new AssertionError("Unknown op: " + this);
        }
    }

    public enum GoodOperation {
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        public abstract double apply(double x, double y);

        private final String symbol;

        GoodOperation(String symbol) {
            this.symbol = symbol;
        }


        @Override
        public String toString() {
            return symbol;
        }

        private static final Map<String, GoodOperation> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, e -> e));

        public static Optional<GoodOperation> fromString(String symbol) {
            return Optional.ofNullable(stringToEnum.get(symbol));
        }
    }

    public enum PayRollDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;
            int overtimePay;
            switch (this) {
                case SATURDAY:
                case SUNDAY:
                    overtimePay = basePay / 2;
                    break;
                default:
                    overtimePay = (minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2);
                    break;
            }
            return overtimePay + basePay;
        }
    }

    public enum GoodPayRoll {
        MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
        private static final int MINS_PER_SHIFT = 8 * 60;
        private final PayType payType;

        private GoodPayRoll(PayType payType) {
            this.payType = payType;
        }

        int pay(int mins, int payRate) {
            return this.payType.pay(mins, payRate);
        }

        private enum PayType {
            WEEKDAY {
                @Override
                int overtimePay(int mins, int payRate) {
                    return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
                }
            }, WEEKEND {
                @Override
                int overtimePay(int mins, int payRate) {
                    return mins * payRate / 2;
                }
            };

            abstract int overtimePay(int mins, int payRate);

            int pay(int mins, int payRate) {
                return mins * payRate + overtimePay(mins, payRate);
            }
        }
    }

    public enum Ensemble {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN;

        int numberOfMusicians() {
            return ordinal() + 1;
        }
    }

    public enum GoodEnsemble {
        ONE(1), TWO(2), THREE(3),
        FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10);

        private final int numberOfMusicians;

        GoodEnsemble(int numberOfMusicians) {
            this.numberOfMusicians = numberOfMusicians;
        }

        int numberOfMusicians() {
            return numberOfMusicians;
        }
    }

    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH;
    }

    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
    }

    static class Plant {
        enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

        final String name;
        final LifeCycle lifeCycle;

        Plant(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum Phase {
        SOLID, LIQUID, GAS, PLASMA;

        public enum BadTransition {
            MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
            private static BadTransition[][] TRANSITIONS =
                    {
                            {null, MELT, SUBLIME},
                            {FREEZE, null, BOIL},
                            {DEPOSIT, CONDENSE, null}
                    };

            public static BadTransition from(Phase from, Phase to) {
                return TRANSITIONS[from.ordinal()][to.ordinal()];
            }
        }

        public enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
            IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

            private final Phase from;
            private final Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }

            private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values())
                    .collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class),
                            toMap(t -> t.to, t -> t, (x, y) -> y,
                                    () -> new EnumMap<Phase, Transition>(Phase.class))));

            public static Transition from(Phase from, Phase to) {
                return m.get(from).get(to);
            }
        }
    }

    public interface Operation {
        double apply(double x, double y);
    }

    public enum BasicOperation implements Operation {
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        }, MINUS("-") {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        }, TIMES("*") {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        }, DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };
        private final String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    public enum ExtendedOperation implements Operation {
        EXP("^") {
            @Override
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        }, REMAINDER("%") {
            @Override
            public double apply(double x, double y) {
                return x % y;
            }
        };
        private final String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    public enum Oper {
        SINGLE, MULTIPLE;
        private Typ type;
        void setType(Typ type) {
            this.type = type;
        }
        Typ getType() {
            return type;
        }


        @Override
        public String toString() {
            return this.name() + ", " + type;
        }
    }

    public enum Typ {
        GET, POST;
    }

    public static void main(String[] args) {
        Oper a = Oper.SINGLE;
        Oper b = Oper.SINGLE;
        a.setType(Typ.GET);
//        b.setType(Typ.POST);
        System.out.println(a);
        System.out.println(b);
        b.setType(Typ.POST);
        System.out.println(a);
        System.out.println(b);

//        test(ExtendedOperation.class, 10f, 5f);
//        test(BasicOperation.class, 5f, 3f);
//        test(Arrays.asList(ExtendedOperation.values()), 10f, 5f);
//        test(Arrays.asList(BasicOperation.values()), 5f, 3f);
//        System.out.println(Phase.Transition.from(Phase.SOLID, Phase.SOLID));
//        System.out.println(GoodEnsemble.ONE.numberOfMusicians());
//        System.out.println(GoodEnsemble.ONE.ordinal());
//        int numDigits = String.valueOf(1000).length();
//        System.out.println(numDigits);
//
//        EnumConst ec = new EnumConst();
//        ec.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));


        Plant[] garden = {
                new Plant("Basil", Plant.LifeCycle.ANNUAL),
                new Plant("Carroway", Plant.LifeCycle.BIENNIAL),
                new Plant("Dill", Plant.LifeCycle.ANNUAL),
                new Plant("Lavendar", Plant.LifeCycle.PERENNIAL),
                new Plant("Parsley", Plant.LifeCycle.BIENNIAL),
                new Plant("Rosemary", Plant.LifeCycle.PERENNIAL)
        };
//        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
//        for (int i = 0; i < plantsByLifeCycle.length; ++i)
//            plantsByLifeCycle[i] = new HashSet<>();
//        for (Plant p : garden)
//            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
//        for (int i = 0; i < plantsByLifeCycle.length; ++i) {
//            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
//        }
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

        System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle)));

        System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
        //
//        double earthWeight = Double.parseDouble("70");
//        double mass = earthWeight / Planet.EARTH.surfaceGravity();
//        for (var planet : Planet.values()) {
//            System.out.printf("Weight on %s is %f%n", planet, planet.surfaceWeight(mass));
//        }
//
//        double x = 10f, y = 20f;
//        for (var op : GoodOperation.values()) {
//            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
//        }
    }
}
