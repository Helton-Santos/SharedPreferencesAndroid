package helton.santos.appaulasp; // SharedPreferences

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_aulaSP";
    private static final String PREF_NOME = "App_aulaSP_pref";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Log.i(TAG, "onCreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Pasta Shared criada");

        dados = sharedPreferences.edit();

        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto",nomeProduto);
        dados.putInt("codigoProduto",codigoProduto);
        dados.putFloat("precoProduto",precoProduto);
        dados.putBoolean("estoque",estoque);

        dados.apply();
        // Modo Debug

        Log.i(TAG, "onCreate: Dados para serem salvos");
        Log.w(TAG, "onCreate: Produto "+nomeProduto);
        Log.w(TAG, "onCreate: Código "+codigoProduto);
        Log.w(TAG, "onCreate: Preço "+precoProduto);
        Log.w(TAG, "onCreate: Tem no estoque "+estoque);

        //dados.clear();
        //dados.apply();

        //dados.remove("estoque"); //Isso era remover o atributo estoque
        //dados.apply();

        Log.i(TAG, "onCreate: Dados recuperados");

        Log.d(TAG, "onCreate: Produto "+sharedPreferences.getString("nomeProduto", "fora do estoque"));
        Log.d(TAG, "onCreate: Código "+sharedPreferences.getInt("codigoProduto",-1));
        Log.d(TAG, "onCreate: Preço "+sharedPreferences.getFloat("precoProduto", -1.0f));
        Log.d(TAG, "onCreate: Tem no estoque "+sharedPreferences.getBoolean("estoque", false));

    }
}