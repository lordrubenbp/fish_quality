package com.team3.fish_quality;

public  class DataSet
{
    public static String kindExplotation ="";
    public static String kindSpecies="";
    public static int production=0;
    public static float feedPercentageCereals=0f;
    public static float feedPercentageFish=0f;
    public static float feedPercentageOthers=0f;
    public static float distConsumidor;
    public static float distProveedor;
    public static float latitude=0f;
    public static float longitude=0f;
    public static float[] monthlyAverageTemp = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
    public static float[] monthlyAverageSolarPower = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
    public static boolean hasHRAP = false;
    public static boolean hasLecho = false;
    public static boolean hasRototamiz = false;
    public static boolean hasSODIS = false;
    public static boolean hasUV = false;
    public static float recirculationPercent = 0f;

    public static float HH;
    public static float Q;  // m^3 / año
    public static float Qmax;   // m^3 / año
    public static float Qent;   // m^3 / año
    public static float consumoCereal;  // m^3 / año
    public static float QProceso;
    public static final float entradaAguaPorLubina = 4.5f;    // m^3 / Kg
    public static final float aguaEnCereal = 0.5f;    // m^3 / Kg
    public static float malimento;  // Kg / año
    public static final float factorAlimentacionLubina = 4.5f;
    public static float consumoCerealConAlgas;   // m^3 / año
    public static float masaAlgas;    // Kg / año
    public static final float productividadAlgas = 100f;   //   g / m^3 / dia
    public static float ahorroCerealConAlgas;

    private static void calculateHH()
    {
        Qent = production * entradaAguaPorLubina;
        masaAlgas = productividadAlgas * Qent * 0.365f;
        consumoCerealConAlgas = (malimento - masaAlgas) * feedPercentageCereals * aguaEnCereal;
        QProceso = Qent * (1.0f - recirculationPercent);
        Q = QProceso + consumoCerealConAlgas;
        malimento = production * factorAlimentacionLubina;
        consumoCereal = malimento * feedPercentageCereals * aguaEnCereal;
        ahorroCerealConAlgas = consumoCereal - consumoCerealConAlgas;
        Qmax = Qent + consumoCereal;
        HH = Q / Qmax;
    }

    public static float HC;
    public static float Mmin;
    public static final float KgCO2Kw = 0.45f;
    public static final float densidad = 1000f;
    public static float Mco2Total;
    public static float Mco2Transporte;
    public static final float HuellaTransporte = 0.0176f;    // Kg / Km
    public static float Mco2Elec;
    public static float elecRoto = 0f;
    public static float elecUV = 0f;
    public static float elecAlgas = 0f;
    public static float elecBombas = 0f;
    public static int NBombas = 1;
    public static float Mco2IC;
    public static float[] monthlyC = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
    public static float Csum = 0f;
    public static final float TPez = 13f;  // ºC
    public static final float Cespec = 4184f;   // J / ºC
    public static final float CCMetano = 50000f;    // KJ / Kg

    private static void calculateHC()
    {
        if (hasRototamiz) {
            NBombas++;
            elecRoto = 8760f;
        }
        if (hasUV) {
            NBombas++;
            elecUV = 0.45f * Qent;
        }
        if (hasHRAP) {
            NBombas++;
            elecAlgas = 10220f;
        }
        if (hasSODIS)
            NBombas++;
        if (hasLecho)
            NBombas++;
        elecBombas = (Mmin / 0.45f) * NBombas;
        Mco2Elec = (elecRoto + elecUV + elecAlgas + elecBombas) * KgCO2Kw;

        for (int i = 0; i < 12; i++) {
            if (monthlyAverageTemp[i] < TPez)
                monthlyC[i] = (Qent / 12000f) * densidad * Cespec * (TPez - monthlyAverageTemp[i]);
            else
                monthlyC[i] = 0.0f;
            Csum += monthlyC[i];
        }
        Mco2IC = Csum / CCMetano;

        Mco2Transporte = (distConsumidor + distProveedor) * 52 * HuellaTransporte;
        Mco2Total = Mco2Elec + Mco2Transporte + Mco2IC;
        Mmin = densidad * Qent * 1.63E-7f * KgCO2Kw;
        HC = 1.0f - (Mmin / Mco2Total);
    }

    public static float OP;
    public static float Ii;
    public static float If;

    public static void calculateOP()
    {
        Ii = feedPercentageCereals + feedPercentageFish;
        If = Ii * (malimento - masaAlgas) / malimento;
        OP = If / Ii;
    }

    public static float CE;
    public static float x1;
    public static float x2;
    public static float x3;

    public static void calculateCE()
    {
        if (hasRototamiz)
            x1 = 0f;
        else
            x1 = 0.5f;
        if (hasHRAP || hasLecho)
            x2 = 0.4f;
        else
            x2 = 0f;
        if (hasUV || hasSODIS)
            x3 = 0f;
        else
            x3 = 0.1f;
        CE = x1 + x2 + x3;
    }

    public static float DE;

    public static void calculateDE()
    {
        DE = HH * 0.3f + HC * 0.4f + OP * 0.1f + CE * 0.2f;
    }

    public static void calculate()
    {
        calculateHH();
        calculateHC();
        calculateOP();
        calculateCE();
        calculateDE();
    }
}
