package com.team3.fish_quality;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NASAScraper
{
    static public void Scrape(String html)
    {
        String result = null;
        List<Float> values = new ArrayList<Float>();

        Pattern word = Pattern.compile("<td align=\"center\" nowrap>");
        Matcher match = word.matcher(html);

        while (match.find())
        {
            int end = match.end();
            values.add(Float.parseFloat(html.substring(end, end+4)));
            System.out.println(values.get(values.size()-1));
        }

        for (int i = 0; i < 12; i++)
        {
            DataSet.monthlyAverageSolarPower[i] = values.get(i);
            DataSet.monthlyAverageTemp[i] = values.get(i+12) + values.get(i+36);
        }
    }
}
