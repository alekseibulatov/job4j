package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1));
        System.out.println(jobs);
        Collections.sort(jobs, new SortByUpNameJob());
        System.out.println(jobs);
        Collections.sort(jobs, new SortByDownNameJob());
        System.out.println(jobs);
        Collections.sort(jobs, new SortByUpPriorityJob());
        System.out.println(jobs);
        Collections.sort(jobs, new SortByDownPriorityJob());
        System.out.println(jobs);
        List<Job> jobs1 = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Fix bugs", 2),
                new Job("Reboot server", 1));
        Collections.sort(jobs1, new SortByUpNameJob().thenComparing(new SortByUpPriorityJob()));
        System.out.println(jobs1);
        Collections.sort(jobs1, new SortByUpNameJob().thenComparing(new SortByDownPriorityJob()));
        System.out.println(jobs1);
    }

}
