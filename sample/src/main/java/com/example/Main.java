package com.example;

public class Main {
    public static void main(String[] args) {
        GradeReportGenerator gradeReportGenerator = new GradeReportGenerator();
        String[] name = {"value1", "value2", "value3"};
        int[] mathsc = {50,44,100};
        int[] scienceScores = {60,44,55};
        int[] englishScores = {50,44,55};
        //String result = gradeReportGenerator.generateReport(name,mathsc,englishScores,scienceScores);
        System.out.println(gradeReportGenerator.calculateAVGScore(name, mathsc, englishScores, scienceScores));
    }
}