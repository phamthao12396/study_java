package com.example;

public class GradeReportGenerator {
    public static final int MIN_SCORE = 0;
    public static final int MAX_SCORE = 100;

    public String generateReport(String[] studentNames, int[] mathScores, int[] englishScores, int[] scienceScores) {

        String checkData = inputValidation(studentNames, mathScores, englishScores, scienceScores);
        if (!checkData.equalsIgnoreCase("valid data")) {
            return checkData;
        } else
            return createReport(studentNames, mathScores, englishScores, scienceScores).toString();
    }

    public String inputValidation(String[] studentNames, int[] mathScores, int[] englishScores, int[] scienceScores) {
        int studentsNumber = studentNames.length;
        int mathLength = mathScores.length;
        int engLength = englishScores.length;
        int scienceLength = scienceScores.length;

        if (studentNames == null || mathScores == null || englishScores == null || scienceScores == null) {
            return "Error: Null input data";
        }

        if (studentsNumber == MIN_SCORE || mathLength == MIN_SCORE || engLength == MIN_SCORE
                || scienceLength == MIN_SCORE) {
            return "Error: Empty input data";
        }

        if (studentsNumber != mathLength || studentsNumber != engLength || studentsNumber != scienceLength) {
            return "Error: Input arrays must have the same length";
        }
        return "Valid data";
    }

    public StringBuilder calculateAVGScore(String[] studentNames, int[] mathScores, int[] englishScores,
            int[] scienceScores) {
        double avgScore;
        StringBuilder result = new StringBuilder();
        // Class average scores
        double classMathAvg = 0;
        double classEnglishAvg = 0;
        double classScienceAvg = 0;
        double classOverallAvg = 0;
        for (int i = 0; i < studentNames.length; i++) {
            // Calculate average score
            avgScore = (mathScores[i] + englishScores[i] + scienceScores[i]) / 3.0;

            // Update class averages
            classMathAvg += mathScores[i];
            classEnglishAvg += englishScores[i];
            classScienceAvg += scienceScores[i];
            classOverallAvg += avgScore;
        }

        // Calculate class averages
        classMathAvg /= studentNames.length;
        classEnglishAvg /= studentNames.length;
        classScienceAvg /= studentNames.length;
        classOverallAvg /= studentNames.length;
        result.append("--------------------------------------------------------\n");
        result.append(String.format("CLASS AVERAGES:  %-8.2f%-11.2f%-11.2f%-11.2f\n",
                classMathAvg, classEnglishAvg, classScienceAvg, classOverallAvg));
        result.append("--------------------------------------------------------\n");

        return result;
    }

    public StringBuilder determiningLetterGrades(String[] studentNames, int[] mathScores, int[] englishScores,
            int[] scienceScores) {
        StringBuilder result = new StringBuilder();
        // Index of student with highest average score
        int highestAvgIndex = 0;
        double highestAvg = 0;

        // Index of student with lowest average score
        int lowestAvgIndex = 0;
        double lowestAvg = 100;
        for (int i = 0; i < studentNames.length; i++) {
            // Calculate average score
            double avgScore = (mathScores[i] + englishScores[i] + scienceScores[i]) / 3.0;

            // Determine students with highest and lowest scores
            if (avgScore > highestAvg) {
                highestAvg = avgScore;
                highestAvgIndex = i;
            }

            if (avgScore < lowestAvg) {
                lowestAvg = avgScore;
                lowestAvgIndex = i;
            }

            // Determine letter grade
            String grade;
            if (avgScore >= 90) {
                grade = "A";
            } else if (avgScore >= 80) {
                grade = "B";
            } else if (avgScore >= 70) {
                grade = "C";
            } else if (avgScore >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Add student information to the report
            result.append(String.format("%-12s%-8d%-11d%-11d%-11.2f%-2s\n",
                    studentNames[i], mathScores[i], englishScores[i], scienceScores[i], avgScore, grade));
        }

        // Add summary information to the report
        result.append("--------------------------------------------------------\n");
        result.append("HIGHEST AVERAGE: " + studentNames[highestAvgIndex] + " (" + String.format("%.2f", highestAvg)
                + ")\n");
        result.append(
                "LOWEST AVERAGE: " + studentNames[lowestAvgIndex] + " (" + String.format("%.2f", lowestAvg) + ")\n");

        return result;
    }

    public StringBuilder createReport(String[] studentNames, int[] mathScores, int[] englishScores,
            int[] scienceScores) {
        StringBuilder result = new StringBuilder();
        // Create header for the report
        result.append("STUDENT GRADE REPORT\n");
        result.append("-------------------\n");
        result.append("Name        Math    English    Science    Average    Grade\n");
        result.append(determiningLetterGrades(studentNames, mathScores, englishScores, scienceScores));
        result.append(calculateAVGScore(studentNames, mathScores, englishScores, scienceScores));
        return result;
    }
}