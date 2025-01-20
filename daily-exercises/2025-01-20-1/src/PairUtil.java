public class PairUtil {
    public static <K, V> void swapPairs(Pair<K, V> pair1, Pair<K, V> pair2) {
        K tempKey = pair1.getKey();
        V tempValue = pair1.getValue();

        pair1.setKey(pair2.getKey());
        pair1.setValue(pair2.getValue());

        pair2.setKey(tempKey);
        pair2.setValue(tempValue);
    }
}
