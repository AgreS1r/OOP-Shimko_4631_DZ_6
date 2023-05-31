public class MyHashMap {
    private final int SIZE = 1000000;
    private Node[] nodes;

    private class Node {
        Integer key;
        Integer value;
        Node next;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public MyHashMap() {
        nodes = new Node[SIZE];
    }

    public Object put(Integer key, Integer value) {
        int index = getIndex(key);
        Node node = nodes[index];
        if (node == null) {
            nodes[index] = new Node(key, value);
            return null;
        }
        while (node.next != null) {
            if (node.key.equals(key)) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }
        if (node.key.equals(key)) {
            Object oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        node.next = new Node(key, value);
        return null;
    }

    public Object get(Integer key) {
        int index = getIndex(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        returnnull;
    }

    public Object remove(Integer key) {
        int index = getIndex(key);
        Node node = nodes[index];
        Node prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    nodes[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public Object replace(Integer key, Integer value) {
        int index = getIndex(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            Node node = nodes[i];
            while (node != null) {
                count++;
                node = node.next;
            }
        }
        return count;
    }

    public boolean containsKey(Integer key) {
        int index = getIndex(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean containsValue(Integer value) {
        for (int i = 0; i < SIZE; i++) {
            Node node = nodes[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private int getIndex(Integer key) {
        return Math.abs(key.hashCode() % SIZE);
    }
}