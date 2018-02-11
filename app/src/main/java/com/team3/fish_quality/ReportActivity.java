package com.team3.fish_quality;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Button backButton= (Button)findViewById(R.id.closeReport);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(false);
        String htmlString =
                "<!doctype html>\n" +
                        "<html lang=\"es\">\n" +
                        "\n" +
                        "<head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "\n" +
                        "  <title></title>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "\n" +
                        "\t<table dir=\"ltr\" width=\"500\" border=\"1\">\n" +
                        "\t<thead>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<th scope=\"col\" colspan=\"2\" align=\"left\">Huella H&iacute;drica</th>\n" +
                        "\t\t</tr>\n" +
                        "\t</thead>\n" +
                        "\t<tbody>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Cereal</td>\n" +
                        "\t\t\t<td align=\"right\">consumoCereal</td>\n" +
                        "\t\t</tr>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Proceso</td>\n" +
                        "\t\t\t<td align=\"right\">QProceso</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</tbody>\n" +
                        "\t<tfoot style=\"background:#ddd;\">\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Total</td>\n" +
                        "\t\t\t<td align=\"right\">QTotal</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</tfoot>\n" +
                        "\t</table>\n" +
                        "\t*Con un HRAP podr&iacute;as haber ahorrado ahorroCerealConAlgas\n" +
                        "\n" +
                        "\t<p/>\n" +
                        "\n" +
                        "\t<table dir=\"ltr\" width=\"500\" border=\"1\">\n" +
                        "\t<thead>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<th scope=\"col\" colspan=\"2\" align=\"left\">Huella de Carbono</th>\n" +
                        "\t\t</tr>\n" +
                        "\t</thead>\n" +
                        "\t<tbody>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Transporte</td>\n" +
                        "\t\t\t<td align=\"right\">Mco2Transporte</td>\n" +
                        "\t\t</tr>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Caldera</td>\n" +
                        "\t\t\t<td align=\"right\">Mco2IC</td>\n" +
                        "\t\t</tr>\n" +
                        "\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Electricidad</td>\n" +
                        "\t\t\t<td align=\"right\">Mco2Elec</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</tbody>\n" +
                        "\t<tfoot style=\"background:#ddd;\">\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>Total</td>\n" +
                        "\t\t\t<td align=\"right\">Mco2Total</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</tfoot>\n" +
                        "\t</table>\n" +
                        "\t*Con un SODIS podr&iacute;as haber ahorrado elecUV\n" +
                        "\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>\n";

        htmlString = htmlString.replaceFirst("consumoCereal", String.valueOf(DataSet.consumoCereal));
        htmlString = htmlString.replaceFirst("QProceso", String.valueOf(DataSet.QProceso));
        htmlString = htmlString.replaceFirst("QTotal", String.valueOf(DataSet.Q));
        htmlString = htmlString.replaceFirst("Mco2Transporte", String.valueOf(DataSet.Mco2Transporte));
        htmlString = htmlString.replaceFirst("Mco2IC", String.valueOf(DataSet.Mco2IC));
        htmlString = htmlString.replaceFirst("Mco2Elec", String.valueOf(DataSet.Mco2Elec));
        htmlString = htmlString.replaceFirst("Mco2Total", String.valueOf(DataSet.Mco2Total));
        htmlString = htmlString.replaceFirst("elecUV", String.valueOf(DataSet.elecUV));

        webView.loadData(htmlString, "text/html; charset=UTF-8", null);
    }
}
