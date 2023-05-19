import java.util.Objects;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        Main.defenceTest();
        System.out.println(Main.divider);
        Main.mainTask();
    }
    public static void mainTask(){
        HashTable hashTable = new HashTable<MyTestingClass, String>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int jobId = rand.nextInt(0, 100);
            String name = NameGenerator.generateFullName();
            double salary = rand.nextDouble(0, 100000);
            hashTable.put(new MyTestingClass(jobId, name, salary), "Full name: " + name +
                    "\nJob: " + jobId + "\nSalary " + salary);
        }
        int[] bucketSize = hashTable.getBucketSize();
        for (int i = 0; i < bucketSize.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSize[i] + " elements");
        }
    }
    public static void defenceTest(){

        System.out.println("> Replace for String (old: Nursultan, new: Khaimuldin)");

        HashTable defenceS = new HashTable<Integer, String>();
        defenceS.put(1, "Nursultan");
        defenceS.replace(1,"Nursultan", "Khaimuldin");
        System.out.println(defenceS.get(1));

        System.out.println("> Replace for integer (old: 10, new: 100)");

        HashTable defenceI = new HashTable<Integer, Integer>();
        defenceI.put(1, 10);
        defenceI.replace(1,10, 100);
        System.out.println(defenceI.get(1));

    }
    static String divider = "=====================================";
}
class MyTestingClass {
    public int jobId;
    public String fullName;
    public double salary;

    public MyTestingClass(int jobId, String fullName, double salary) {
        this.jobId = jobId;
        this.fullName = fullName;
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + jobId;
        result = 31 * result + (fullName == null ? 0 : stringHashCode(fullName));
        long temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return Math.abs(result);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyTestingClass)) {
            return false;
        }
        MyTestingClass other = (MyTestingClass) obj;
        return jobId == other.jobId && Objects.equals(fullName, other.fullName)
                && Double.compare(salary, other.salary) == 0;
    }
    private int stringHashCode(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = 31 * hash + s.charAt(i);
        }
        return Math.abs(hash);
    }

}