package by.borisevich.phone.book.tool;

import by.borisevich.phone.book.tool.serialization.CustomObject;
import by.borisevich.phone.book.tool.serialization.DataObject;
import com.google.gson.Gson;

/**
 * Created by dima on 10/2/16.
 */

//HashSet, TreeSet Navigable;
//LinkedHashMap (capacity, loadFactory, accessOrder) LRU-cache
//WeakHashMap
//PriorityQueue with Comparator and Comparable
//Concurrent
//SynchronousQueue
public class Check {


    public static void main(String[] args) {
        DataObject object = new DataObject();
        object.setMyData("sdfhsfkhdsafuaufakufhaskudfhuashfkadsuhfkuh");
        object.setI(3);
        object.setS("test");
        object.getCustomObject().add(new CustomObject(true));
        object.getCustomObject().add(new CustomObject(false));
        Gson gson = new Gson();

        String json = gson.toJson(object);

        DataObject obj = gson.fromJson(json, DataObject.class);

        System.out.println(json);
    }

    //Serialization xml
//    static final String PACKAGE = DataObject.class.getPackage().getName();
//
//    public static void main(String[] args) throws JAXBException {
//        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
//
//        Marshaller m = jc.createMarshaller();
//        m.setProperty("jaxb.formatted.output", true);
//        Unmarshaller um = jc.createUnmarshaller();
//
//        DataObject object = new DataObject();
//        object.setMyData("sdfhsfkhdsafuaufakufhaskudfhuashfkadsuhfkuh");
//        object.setI(3);
//        object.setS("test");
//        object.getCustomObject().add(new CustomObject(true));
//        object.getCustomObject().add(new CustomObject(false));
//        File file = new File("store.xml");
//
//        m.marshal(object, file);
//
//        DataObject objNew = (DataObject) um.unmarshal(file);
//        System.out.println(objNew.getMyData());
//        System.out.println(objNew.getI());
//        System.out.println(objNew.getS());
//        for (CustomObject obj:object.getCustomObject())
//            System.out.println(obj.isB());
//    }
//

    // Serializable, Externalizable
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        DataObject object = new DataObject();
//        object.setMyData("sdfhsfkhdsafuaufakufhaskudfhuashfkadsuhfkuh");
//        object.setI(3);
//        object.setS("test");
//        object.getCustomObject().add(new CustomObject(true));
//        object.getCustomObject().add(new CustomObject(false));
//        File file = new File("store2.bin");
//
//        FileOutputStream fo = new FileOutputStream(file);
//        ObjectOutputStream so = new ObjectOutputStream(fo);
//        so.writeObject(object);
//        so.flush();
//        so.close();
//
//        FileInputStream fi = new FileInputStream(file);
//        ObjectInputStream si = new ObjectInputStream(fi);
//        DataObject objNew = (DataObject) si.readObject();
//        si.close();
//
//        System.out.println(objNew.getMyData());
//        System.out.println(objNew.getI());
//        System.out.println(objNew.getS());
//        for (CustomObject obj:object.getCustomObject())
//            System.out.println(obj.isB());
//    }

    //Generic
//    public static void main(String[] args) {
//        SomeType<?> someType = new SomeType();
//        List<String> list = Arrays.asList("test");
//        someType.test(list);
//
//        Camera camera1 = new Camera();
//        Product<Camera> camera2 = new Camera();
//        Phone phone = new Phone();
//
//        List<Product<Camera>> list2 = new ArrayList<Product<Camera>>();
//
//        camera1.compareTo(camera2);
//        list2.add(camera2);
//        list2.add(camera1);
//        list2.add(phone);
//
//    }

    //SynchronousQueue
//    public static void main(String[] args) {
//        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
//
//        new Thread(new Producer(queue)).start();
//
//        new Thread(new Consumer(queue)).start();
//    }

    //Concurrent
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>(1000));
//        List<Integer> list2 = new CopyOnWriteArrayList<Integer>();
//        List<Integer> list3 = Collections.synchronizedList(new LinkedList<Integer>());
//
//        fillList(list1, 1000);
//        fillList(list2, 1000);
//        fillList(list3, 1000);
//
//        System.out.println("--ArrayList synchronized");
//        checkList(list1);
//
//        System.out.println("--CopyOnWriteArrayList");
//        checkList(list2);
//
//        System.out.println("--LinkedList synchronized");
//        checkList(list3);
//
//    }
//
//    private static void checkList(List<Integer> list) throws ExecutionException, InterruptedException {
//        CountDownLatch count = new CountDownLatch(1);
//
//        ExecutorService ex = Executors.newFixedThreadPool(2);
//
//        Future<Long> f1 = ex.submit( new ListRunner(0, 500, list, count));
//
//        Future<Long> f2 = ex.submit( new ListRunner(500, 1000, list, count));
//
//        count.countDown();
//        System.out.println("Thread 1: " + f1.get()/1000);
//        System.out.println("Thread 2: " + f2.get()/1000);
//        System.out.println(list.size());
//    }
//
//    private static void fillList(List<Integer> list, int count) {
//        for (int i=0; i < count; i++)
//            list.add(i);
//    }

//    PriorityQueue with Comparator and Comparable
//    public static void main(String[] args) {
//        Queue<TestData> queue = new PriorityQueue<TestData>(new Comparator<TestData>() {
//            public int compare(TestData o1, TestData o2) {
//                if (o1.getI()%2 == o2.getI()%2) {
//                    return o1.getI().compareTo(o2.getI());
//                } else if (o1.getI()%2 < o2.getI()%2) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        for(int i = 0; i<5; i++){
//            queue.add(new TestData(i));
//        }
//
//        System.out.println("--new Comparator example");
//        while (!queue.isEmpty())
//            System.out.println(queue.poll());
//
//        Queue<Data> queue2 = new PriorityQueue<Data>();
//
//        for(int i = 0; i<5; i++){
//            queue2.add(new Data(i));
//        }
//
//        System.out.println("--Comparable interface example");
//        while (!queue2.isEmpty())
//            System.out.println(queue2.poll());
//
//    }
//
//    private static class TestData {
//        private Integer i;
//        private String text;
//
//        public TestData(int i) {
//            this.i = i;
//        }
//
//        public Integer getI() {
//            return i;
//        }
//
//        public void setI(Integer i) {
//            this.i = i;
//        }
//
//        public String getText() {
//            return text;
//        }
//
//        public void setText(String text) {
//            this.text = text;
//        }
//
//        @Override
//        public String toString() {
//            return "i="+ i + " text: new Comparator";
//        }
//    }
}
