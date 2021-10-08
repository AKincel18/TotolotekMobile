    package pl.polsl.java.adam.kincel.totolotek.main;

    import android.content.Context;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

    import java.util.InputMismatchException;

    import pl.polsl.java.adam.kincel.totolotek.R;
    import pl.polsl.java.adam.kincel.totolotek.model.*;

    public class EnteringNumbersActivity extends AppCompatActivity {
        Context context;
        Totolotek totolotek = new Totolotek(); //create model
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.entering_numbers_activity);
            Button b = (Button)findViewById(R.id.drawNumbersButton);
            b.setOnClickListener((View.OnClickListener) view -> {
                try {
                    int [] ids = new int[] {R.id.number1, R.id.number2,R.id.number3,R.id.number4,R.id.number5,R.id.number6 };
                    for (int id = 0; id < ids.length ; id++) {
                        EditText t=(EditText)findViewById(ids[id]);
                        totolotek.isGoodNumber(Integer.parseInt(t.getText().toString()));
                        totolotek.setNumber(id, Integer.parseInt(t.getText().toString()));
                    }

                    totolotek.isRepeatable(totolotek.getUserArray());
                    context = getApplicationContext();
                    Intent intent = new Intent(context, ResultsActivity.class);
                    intent.putExtra("model", totolotek); //send model to second activity
                    startActivity(intent);

                } catch(MyException e){
                    Toast.makeText(getApplicationContext(),e.getMessage() + "Wrong number: " + e.getExceptionNumber(),Toast.LENGTH_SHORT).show();

                } catch(NumberFormatException  | InputMismatchException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



