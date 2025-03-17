package com.example;

public class GradeReportGenerator {

    public String generateReport(String[] studentNames, int[] mathScores, int[] englishScores, int[] scienceScores) {
         String result = "";

        String checkData = inputValidation(studentNames, mathScores, englishScores, scienceScores);
        if (!checkData.equalsIgnoreCase("valid data")) {
            return checkData;
        }


        // Create header for the report
        result += "STUDENT GRADE REPORT\n";
        result += "-------------------\n";
        result += "Name        Math    English    Science    Average    Grade\n";
        result += "--------------------------------------------------------\n";

        // Index of student with highest average score
        int highestAvgIndex = 0;
        double highestAvg = 0;

        // Index of student with lowest average score
        int lowestAvgIndex = 0;
        double lowestAvg = 100;

        // Class average scores
        double classMathAvg = 0;
        double classEnglishAvg = 0;
        double classScienceAvg = 0;
        double classOverallAvg = 0;

        // Process each student
        for (int i = 0; i < studentNames.length; i++) {
            // Validate scores
            if (mathScores[i] < 0 || mathScores[i] > 100 || englishScores[i] < 0 || englishScores[i] > 100
                    || scienceScores[i] < 0 || scienceScores[i] > 100) {
                return "Error: Invalid score for student " + studentNames[i] + ". Scores must be between 0 and 100.";
            }

            // Calculate average score
            double avgScore = (mathScores[i] + englishScores[i] + scienceScores[i]) / 3.0;

            // Update class averages
            classMathAvg += mathScores[i];
            classEnglishAvg += englishScores[i];
            classScienceAvg += scienceScores[i];
            classOverallAvg += avgScore;

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
            result += String.format("%-12s%-8d%-11d%-11d%-11.2f%-2s\n",
                    studentNames[i], mathScores[i], englishScores[i], scienceScores[i], avgScore, grade);
        }

        // Calculate class averages
        classMathAvg /= studentNames.length;
        classEnglishAvg /= studentNames.length;
        classScienceAvg /= studentNames.length;
        classOverallAvg /= studentNames.length;

        // Add summary information to the report
        result += "--------------------------------------------------------\n";
        result += String.format("CLASS AVERAGES:  %-8.2f%-11.2f%-11.2f%-11.2f\n",
                classMathAvg, classEnglishAvg, classScienceAvg, classOverallAvg);
        result += "--------------------------------------------------------\n";
        result += "HIGHEST AVERAGE: " + studentNames[highestAvgIndex] + " (" + String.format("%.2f", highestAvg)
                + ")\n";
        result += "LOWEST AVERAGE: " + studentNames[lowestAvgIndex] + " (" + String.format("%.2f", lowestAvg) + ")\n";

        return result;
    }
    public String inputValidation(String[] studentNames, int[] mathScores, int[] englishScores, int[] scienceScores){
        // Input validation
        if (studentNames == null || mathScores == null || englishScores == null || scienceScores == null) {
            return "Error: Null input data";
        }
    
        if (studentNames.length == 0 || mathScores.length == 0 || englishScores.length == 0
                || scienceScores.length == 0) {
            return "Error: Empty input data";
        }
    
        if (studentNames.length != mathScores.length || studentNames.length != englishScores.length
                || studentNames.length != scienceScores.length) {
            return "Error: Input arrays must have the same length";
        }
        return "Valid data";
    }

    public double calculateAVGScore(String[] studentNames, int[] mathScores, int[] englishScores, int[] scienceScores){
        double score = 0;
        for (int i = 0; i < studentNames.length; i++) {
            // Validate scores
            if (mathScores[i] < 0 || mathScores[i] > 100 || englishScores[i] < 0 || englishScores[i] > 100
                    || scienceScores[i] < 0 || scienceScores[i] > 100) {
                System.out.println("Error: Invalid score for student " + studentNames[i] + ". Scores must be between 0 and 100.");
                return 0;
            }

            // Calculate average score
            score = (mathScores[i] + englishScores[i] + scienceScores[i]) / 3.0;
        }
        return score;
    }

    public String letterGrade(){
        return "";
    }
}
