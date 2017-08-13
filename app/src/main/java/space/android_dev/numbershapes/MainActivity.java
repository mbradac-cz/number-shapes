package space.android_dev.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void processFunction (View view){

        CheckBox isPositiveCheck = (CheckBox) findViewById(R.id.checkPositive);
        CheckBox isNegativeCheck = (CheckBox) findViewById(R.id.checkNegative);
        CheckBox isEvenCheck = (CheckBox) findViewById(R.id.checkEven);
        CheckBox isOddCheck = (CheckBox) findViewById(R.id.checkOdd);
        CheckBox isZeroCheck = (CheckBox) findViewById(R.id.checkZero);
        CheckBox isSquareCheck = (CheckBox) findViewById(R.id.checkSquare);
        CheckBox isTriangularCheck = (CheckBox) findViewById(R.id.checkTriangular);


        EditText insertedNumber = (EditText) findViewById(R.id.inNumber);
        String inNumberString = insertedNumber.getText().toString();
        if (inNumberString.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Nothing inserted !", Toast.LENGTH_SHORT).show();

            isPositiveCheck.setChecked(false);
            isNegativeCheck.setChecked(false);
            isEvenCheck.setChecked(false);
            isOddCheck.setChecked(false);
            isZeroCheck.setChecked(false);
            isSquareCheck.setChecked(false);
            isTriangularCheck.setChecked(false);

        } else {
            int number = Integer.parseInt(insertedNumber.getText().toString());
            // Decimal number cannot be inserted, otherwise needs to be checked


            TestNumber myNumber = new TestNumber();
            myNumber.evaluate(number);

            isPositiveCheck.setChecked(false);
            isNegativeCheck.setChecked(false);
            isEvenCheck.setChecked(false);
            isOddCheck.setChecked(false);
            isZeroCheck.setChecked(false);
            isSquareCheck.setChecked(false);
            isTriangularCheck.setChecked(false);



            isPositiveCheck.setEnabled(true);
            isNegativeCheck.setEnabled(true);
            isEvenCheck.setEnabled(true);
            isOddCheck.setEnabled(true);
            isZeroCheck.setEnabled(true);
            isSquareCheck.setEnabled(true);
            isTriangularCheck.setEnabled(true);

            if (myNumber.positive) {
                isPositiveCheck.setChecked(true);
            }
            if (myNumber.negative) {
                isNegativeCheck.setChecked(true);
            }
            if (myNumber.isEven) {
                isEvenCheck.setChecked(true);
            }
            if (myNumber.isOdd) {
                isOddCheck.setChecked(true);
            }
            if (myNumber.isZero) {
                isZeroCheck.setChecked(true);
            }
            if (myNumber.isSquare) {
                isSquareCheck.setChecked(true);
            }
            if (myNumber.isTriang) {
                isTriangularCheck.setChecked(true);
            }

            }

        }

    public class TestNumber {
        boolean positive = false;
        boolean negative = false;
        boolean isZero = false;
        boolean isEven = false;
        boolean isOdd = false;
        boolean isSquare = false;
        boolean isTriang = false;

        public void evaluate(int number){
            positiveTest(number);
            evenTest(number);

            if (this.positive){
                isSquare(number);
                isTriang(number);
            }

        }


        private void positiveTest(int number) {

            if (number > 0) {
                this.positive = true;
            } else if (number < 0){
                this.negative = true;
            } else {
                this.isZero = true;
            }
        }

        private void evenTest (int number){

            if ((number % 2) == 0) {
                this.isEven = true;
            } else {
                this.isOdd = true;
            }
        }

        private void isSquare (int number) {
            double sqrt = Math.sqrt(number);
            int x = (int) sqrt;
            if (Math.pow(sqrt, 2) == Math.pow(x,2)){
                isSquare = true;
            }
        }

        private void isTriang (int number){
            {
                long n = (long) Math.sqrt(2 * number);
                if (n * (n + 1) / 2 == number){
                    isTriang = true;
                }
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
