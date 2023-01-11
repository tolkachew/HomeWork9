import java.util.Objects;
import java.util.function.BiConsumer;

// Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
// Реализуйте методы getFirst(), getSecond(), equals() и hashCode().
// Реализуйте статический фабричный метод of(). Конструктор должен быть закрытым (private).
// Реализуйте метод ifPresent, аналогичный одноименному методу класса Optional и принимающий java.util.function.BiConsumer
// Реализуйте метод empty(), который возвращает экземпляр с нулевыми полями {null,null} (см. реализацию в классе Optional).

public class HW {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst();
        String s = pair.getSecond();
        pair.ifPresent((first, second) -> {
            System.out.print(first+" ");
            System.out.println(second);
        });
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();

    }
}

class Pair<K, V> {
    private final K first;
    private final V second;

    private Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    private static final Pair<?, ?> EMPTY = new Pair<>(null, null);

    public static <K, V> Pair<K, V> empty() {
        return (Pair<K, V>) EMPTY;
    }

    public static <K, V> Pair of(K first, V second) {
        return new Pair<>(first, second);
    }

    public void ifPresent(BiConsumer<? super K, ? super V> action) {
        if (first != null && second != null) {
            action.accept(first, second);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}