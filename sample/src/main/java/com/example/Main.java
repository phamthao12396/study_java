package com.example;

public class Main {
    public static void main(String[] args) {
        GradeReportGenerator gradeReportGenerator = new GradeReportGenerator();
        String[] name = {"value1", "value2", "value3"};
        int[] mathsc = {11,44,55};
        int[] scienceScores = {11,44,55};
        int[] englishScores = {11,44,55};
        gradeReportGenerator.generateReport(name,mathsc,englishScores,scienceScores);
    }
}