/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fin.servlet;

import org.fin.ejb.FinancialService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinancialServlet")
public class FinancialServlet extends HttpServlet {

    static String PAGE_HEADER = "<html><head><title>FinancialServlet</title><style>h1 {text-align: center;}</style></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @EJB
    FinancialService financialService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);
        writer.println("<h1>" + financialService.getDeploymentInformations("MyFinancial App") + "</h1>");
        writer.println("<p>");
        writer.println("REST API Available :<br>");
        writer.println("<ul>");
        writer.println("<li><a href=\"/MyFinancialWeb/rest/currency/currencies\">/MyFinancialWeb/rest/currency/currencies</a>");
        writer.println("</ul>");
        writer.println(PAGE_FOOTER);
        writer.close();
    }
}
