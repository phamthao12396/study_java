package com.example;

public class Main {
    public static void main(String[] args) {
        GradeReportGenerator gradeReportGenerator = new GradeReportGenerator();
        String[] name = {"Thao", "Bo", "Bin"};
        int[] mathsc = {70,94,100};
        int[] scienceScores = {60,84,100};
        int[] englishScores = {50,84,100};
        String result = gradeReportGenerator.generateReport(name,mathsc,englishScores,scienceScores);
        System.out.println(result);
    }
}