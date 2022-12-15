package com.ace.cigna.DemoApp.streamdata;

import com.ace.cigna.DemoApp.entity.Employee;
import com.ace.cigna.DemoApp.entity.StudentData;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Here practices all stream methods
 * create each method and call from main only
 */
public class StreamMethods {

    public static void main(String[] args) {
        //reverseString();
        //findMaxAndMinNumber();
        //convertListToMap();
        //removeDuplicateKeysFromList();
        //findNumberWhichAreStartWithOne();
        //findTotalNumberOfElements();
        //flatMapExample();
        //sortMap();
       // findDuplicatesInList();
        //streamIsNotReuseButTryToReuseBySupplier();
        //findNumberOfItemsOrWordRepeated();
        //sumOfNumbers();
        //findSecondHighestNumber();
        //reduceMethodTest();
        //reverseSentenceWordByWord();

        //countDuplicatesCharInString();
        testEmployeeWithOutComparator();

    }

    public static void testEmployeeWithOutComparator(){
        List<Employee> empList = new ArrayList<>();
        Employee emp1 = new Employee(1,"Evan",30,1000);
        Employee emp2 = new Employee(2,"Ethan",32,9000);
        Employee emp3 = new Employee(3,"Arya",33,12000);
        Employee emp4 = new Employee(4,"Prasanth",30,1700);
        Employee emp5 = new Employee(5,"Suhan",45,20000);
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
       // empList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        //print max salary
        Employee employee = empList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
        System.out.println(employee);
    }

    public static void countDuplicatesCharInString(){
        String input = "Hello World";
        Map<String, Long> collect = input.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Objects::toString, Collectors.counting()));
        collect.forEach((k,v) -> System.out.println("key :: "+k+" ----- Value :: "+v));
        System.out.println("Hii...");
    }

    /**
     * reverse a Sentence by using string
     */
    public static void reverseSentenceWordByWord(){
        String input = "I am good";
        String[] words = input.split(" ");
        String output = "";
        for (String word : words){
            String reverse = "";
            for(int i = word.length()-1; i>=0; i--){
                reverse = reverse+word.charAt(i);
            }
            output = output+reverse+" ";
        }
        System.out.println(output);

        // reverse Sentence Word By Word in stream
        String collect = Pattern.compile(" +").splitAsStream("Hello World !")
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining("\" \" ","\"","\""));
        System.out.println(collect);
    }


    /**
     * reduce(T identity, BinaryOperator<T> accumulator)
     */
    public static void reduceMethodTest(){
        int even = getNumbers().stream()
                .filter(x->x%2==0)
                .reduce(9,(i1,i2)-> i1+i2);

        System.out.println(even);
    }

    /**
     * Find the second highest salaye or any position value we can get
     */
    public static void  findSecondHighestNumber(){
        List<Integer> numbers = getNumbers();
        Integer integer = numbers.stream().distinct().sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(integer);
    }

    /**
     * summ of the all numbers
     */
    public static void  sumOfNumbers(){
        Optional<Integer> reduce = getNumbers().stream().reduce((a, b) -> a + b);
        reduce.ifPresent(System.out::println);
    }

    /**
     * count the repeated word like mani=1, kumar=2
     */
    public static void findNumberOfItemsOrWordRepeated (){
        Map<String, Long> collect = getStrings()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    /**
     * stream is not reuse to do like we need supplier method
     * but my code is working fine, I have to check that.
     */
    public static void streamIsNotReuseButTryToReuseBySupplier(){
        //it's working fine
        // I have to know the difference
        /*List<String> data = Arrays.asList("mani", "kumar", "mani");
        data.stream().forEach(d -> System.out.println(d));
        long count = data.stream().filter(s -> "mani".equals(s)).count();
        System.out.println("Count :: "+count);*/

        //it's getting Runntime Exception "IllegalStateException"
        //To resolve this we need supplier.
        String[] inputArray = {"Amit","ball", "call", "Amit"};
        Supplier<Stream<String>> inputStream = () -> Stream.of(inputArray);

        inputStream.get().forEach(es -> System.out.println(es));
        long count = inputStream.get().filter(d -> "Amit".equals(d)).count();
        System.out.println(count);

    }

    /**
     * find duplicates elements in a list
     */
    public static void findDuplicatesInList(){
        Set<Integer> set = new HashSet<>();
       // getNumbers().stream().filter(l -> !set.add(l)).forEach(System.out::print);

        Set<Integer> collect = getNumbers().stream().filter(e -> Collections.frequency(getNumbers(), e) > 1)
                .collect(Collectors.toSet());
        System.out.println(collect);

        //Remove duplicates
        //System.out.println("");
       // getNumbers().stream().distinct().forEach(System.out::print);
    }


    /**
     * sort a map<Integer, String>
     */
    public static void sortMap(){
        Map<Integer, String> mapOfKeyandValue = getMapOfKeyandValue();
        mapOfKeyandValue.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).forEach(System.out::print);
    }

    /**
     * convert multiple student  list of objects into a single list
     */
    public static void flatMapExample(){
        List<StudentData> list1 = new ArrayList<>();
        list1 = getStudents();
        List<StudentData> list2 = new ArrayList<>();
        list2 = getStudents();
        List<StudentData> list3 = new ArrayList<>();
        list3 = getStudents();

        List<List<StudentData>> allLists = Arrays.asList(list1, list2, list3);
        List<StudentData> allCollection = allLists.stream()
                .flatMap(sl -> sl.stream()).collect(Collectors.toList());
        System.out.println("stu :: "+allCollection);

        List i1 = Arrays.asList(2, 4, 7);
        List i2 = Arrays.asList(4, 7, 8);
        List i3 = Arrays.asList(1, 3, 9);
        List all = new ArrayList<>();
        all.addAll(Arrays.asList(i1,i2,i3));

        List<List<Integer>> listOfListofInts = Arrays.asList(i1, i2, i3);


         listOfListofInts.stream()
                .flatMap(l -> l.stream())
                 .collect(Collectors.toList())
                 .stream().sorted()
                 .distinct()
                 .forEach(System.out::print);
        //System.out.println(collect);
    }
    /**
     * count total elements from list
     */
    public static void findTotalNumberOfElements(){
        long count = getNumbers().stream().count();
        System.out.println(count);
    }

    /**
     * get all elements which are starts with 1 only
     */
    public static void findNumberWhichAreStartWithOne(){
        List<Integer> input = getNumbers();
        input.stream().map(e -> e+" ").filter(e -> e.startsWith("1")).forEach(System.out::println);
    }

    /**
     * remove the duplicates name and make it as a key
     * value is student object
     */
    public static void removeDuplicateKeysFromList(){
        List<StudentData> studentsList = getStudents();
        //student name is key and value is student object
        //but name can have duplicates we have to remove duplicates names.
        Map<String, StudentData> result = studentsList.stream()
                .collect(Collectors.toMap(StudentData::getName,
                        Function.identity(),
                        (s2, s1) -> s1));

        //TreeMap::new -> it's for sorting purpose only
        /*Map<String, Student> result = studentsList.stream()
                .collect(Collectors.toMap(Student::getName,
                        Function.identity(),
                        (s2, s1) -> s1, TreeMap::new));*/
        result.forEach((k,v)-> System.out.println(k+" :: "+v));
    }

    /**
     * convert List of Objects to map
     * key is the id integer and value is the student object
     */
    public static void convertListToMap(){
        List<StudentData> students = getStudents();
        Map<Integer, StudentData> collect = students.stream()
                .collect(Collectors.toMap(StudentData::getId, Function.identity()));
        collect.forEach((k,v) -> System.out.println("k :: "+k+"--- value :: "+collect.get(k)));
    }

    /**
     * find the max and min element in the int list
     */
    public static void findMaxAndMinNumber(){
        List<Integer> numbers = getNumbers();
        Integer maxValue = numbers.stream().max(Integer::compareTo).get();
        System.out.println("Max value :: "+maxValue);
        Integer minValue = numbers.stream().min(Integer::compareTo).get();
        System.out.println("Min value :: "+minValue);
    }
    /**
     * reverse the string values
     */
    public static void reverseString(){
        List<String> input = getStrings();
        input.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }

    /**
     * @return list of the students
     */
    public static List<StudentData> getStudents(){
        List<StudentData> studentsList = new ArrayList<>();
        StudentData student1 = new StudentData(1,"mani",35);
        StudentData student2 = new StudentData(2,"kumar",34);
        StudentData student3 = new StudentData(3,"ratna",33);
        StudentData student4 = new StudentData(4,"sudha",33);
        StudentData student5 = new StudentData(5,"santhamma",40);
        StudentData student6 = new StudentData(6,"mani",30);
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
        studentsList.add(student6);

        return studentsList;
    }

    /**
     * @return list of employees
     */
    public static List<StudentData> getEmployees(){
        List<StudentData> empList = new ArrayList<>();
        StudentData emp1 = new StudentData(1,"Evan",30);
        StudentData emp2 = new StudentData(2,"Ethan",32);
        StudentData emp3 = new StudentData(3,"Arya",33);
        StudentData emp4 = new StudentData(4,"Prasanth",30);
        StudentData emp5 = new StudentData(5,"Suhan",45);
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);

        return empList;
    }

    /**
     * @return list of numbers
     */
    public static List<Integer> getNumbers(){
       return Arrays.asList(1,2,3,5,6,2,4,3,8,7,9,5);
    }

    /**
     * @return list of string of names
     */
    public static List<String> getStrings(){
        return Arrays.asList("mani", "kumar", "panithi","evan","ethan","ratna","sudha", "kumar");
    }

    public static Map<Integer, String> getMapOfKeyandValue(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"fore");
        map.put(5,"five");
        return map;
    }

}
