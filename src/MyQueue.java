
/**
 * Generic version of the Queue class.
 *
 * @param <T> the type of the value
 */
class MyQueue<T> {

    /**
     * Head node contains front node in the queue
     */
    Node<T> head;

    /**
     * Tail node contains last node in the queue
     */
    Node<T> tail;

    public MyQueue() {
        head = tail = null;
    }

    // Hàm thêm (lưu trữ) một item vào queue.
    public void enqueue(T x) {
        if (isEmpty()) {
            head = tail = new Node<>(x, null);
        } else {
            tail.next = new Node<>(x, null);

            tail = tail.next;
        }

    }

    // Hàm xóa (truy cập) một item trên queue.
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception();

        T x = head.info;

        head = head.next;

        if (head == null)
            tail = null;

        return (x);

    }

    // Hàm  Lấy phần tử ở trước queue mà không xóa phần tử đó.
    public T front() throws Exception {
        if (isEmpty())
            throw new Exception();

        return (head.info);

    }

    // Hàm Kiểm tra xem queue có trống phần tử không.
    public boolean isEmpty() {
        return (head == null);
    }

}