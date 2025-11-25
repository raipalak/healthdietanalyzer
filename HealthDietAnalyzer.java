import java.util.*;

public class HealthDietAnalyzer {

    // --- BMI CALCULATOR ---
    static double calculateBMI(double weightKg, double heightCm) {
        double h = heightCm / 100.0;
        return weightKg / (h * h);
    }

    static String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    // --- BMR CALCULATOR ---
    static double calculateBMR(String gender, double weight, double height, int age) {
        gender = gender.toLowerCase();
        if (gender.equals("male")) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
    }

    // --- TDEE ---
    static double getActivityMultiplier(int level) {
        return switch (level) {
            case 1 -> 1.2;      // sedentary
            case 2 -> 1.375;    // light exercise
            case 3 -> 1.55;     // moderate exercise
            case 4 -> 1.725;    // heavy exercise
            case 5 -> 1.9;      // athlete
            default -> 1.2;
        };
    }

    // --- Diet Generator ---
    static String generateDietPlan(String goal) {
        goal = goal.toLowerCase();
        StringBuilder sb = new StringBuilder("\n---- DIET PLAN ----\n");

        if (goal.equals("lose")) {
            sb.append("""
                    Breakfast: Oats + Fruits + Green tea
                    Lunch: Roti (2) + Dal + Sabzi (low oil)
                    Snack: Nuts (5–6) + Black Coffee
                    Dinner: Grilled paneer/chicken + Salad (no rice)
                    """);
        } else if (goal.equals("maintain")) {
            sb.append("""
                    Breakfast: Eggs/Oats + Milk
                    Lunch: Roti (3) + Dal + Sabzi + Curd
                    Snack: Fruits or peanuts
                    Dinner: Rice + Dal + Sabzi + Protein source
                    """);
        } else { // gain weight
            sb.append("""
                    Breakfast: Oats with peanut butter + Banana shake
                    Lunch: Roti (4) + Dal + Sabzi + Rice (1 bowl)
                    Snack: Peanut butter sandwich + Milk
                    Dinner: Rice + Paneer/Chicken + Dal + Salad
                    """);
        }

        return sb.toString();
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== HEALTH & DIET ANALYZER ===");

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Gender (Male/Female): ");
        String gender = sc.next();

        System.out.print("Enter Height (cm): ");
        double height = sc.nextDouble();

        System.out.print("Enter Weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("""
                Activity Level:
                1. Little/No exercise
                2. Light exercise
                3. Moderate exercise
                4. Heavy exercise
                5. Athlete
                Enter choice: 
                """);
        int activity = sc.nextInt();

        System.out.print("Goal (Lose/Maintain/Gain): ");
        String goal = sc.next();

        // calculations
        double bmi = calculateBMI(weight, height);
        double bmr = calculateBMR(gender, weight, height, age);
        double tdee = bmr * getActivityMultiplier(activity);

        // calorie adjustment
        double targetCalories = switch (goal.toLowerCase()) {
            case "lose" -> tdee - 400;
            case "gain" -> tdee + 400;
            default -> tdee;
        };

        System.out.println("\n======== RESULTS ========");
        System.out.printf("BMI: %.2f (%s)\n", bmi, getBMICategory(bmi));
        System.out.printf("BMR: %.2f calories/day\n", bmr);
        System.out.printf("TDEE: %.2f calories/day\n", tdee);
        System.out.printf("Recommended Daily Calories: %.2f\n", targetCalories);

        System.out.println(generateDietPlan(goal));
    }
}

