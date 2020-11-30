package core_java;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class BenchMark {

    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        @Param({"100", "200", "500"})
        public int iterations;
        public Hasher murmur3;
        public String password = "4v3rys3kur3p455w0rd";

        @Setup(Level.Invocation)
        public void setUp() {
            murmur3 = Hashing.murmur3_128().newHasher();
        }
    }

//    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 2)
    public void benchMurmur3_128(ExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            plan.murmur3.putString(plan.password, Charset.defaultCharset());
        }
        plan.murmur3.hash();
    }

//    @Benchmark
    @Fork(value = 1, warmups = -1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    public void doNothing() {

    }

//    @Benchmark
    @Fork(value = 1, warmups = -1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    public Object objectCreation() {
        return new Object();
    }

//    @Benchmark
    @Fork(value = 1, warmups = -1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    public void blackHole(Blackhole blackhole) {
        blackhole.consume(new Object());
    }

//    @Benchmark
//    @Fork(value = 1, warmups = 2)
    public void init() {
    }

    @State(Scope.Benchmark)
    public static class Log {
        public int x = 8;
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    public double log(Log input) {
        return Math.log(input.x);
    }
}
