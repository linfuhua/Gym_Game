package com.gdou317.gym_game.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultUtils {
    public static void toJson(HttpServletResponse response, Object data)
            throws IOException {
        Gson gson = new Gson();
        String result = gson.toJson(data);
        response.setContentType("text/json; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    public static void writeResponseData(HttpServletRequest request, HttpServletResponse response, Object data)
    {
        response.setContentType("text/html;charset=utf-8");
        try
        {
            PrintWriter out = response.getWriter();
            out.println(data.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}



