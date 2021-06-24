/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.daos.UserDAO;
import sample.dtos.UserDTO;
import sample.dtos.UserError;

/**
 *
 * @author phath
 */
public class CreateController extends HttpServlet {

    private static final String SUCCESS = "login.html";
    private static final String ERROR = "createUser.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError("", "", "", "", "");
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            boolean flag = true;

            if (userID.length() > 10 || userID.length() < 1) {
                flag = false;
                userError.setUserIDError("UserID must be (2-10)");
            }
            if (fullName.length() > 10 || fullName.length() < 1) {
                flag = false;
                userError.setFullNameError("fullName must be (2-10)");
            }
            if (roleID.length() > 5 || roleID.length() < 1) {
                flag = false;
                userError.setRoleIDError("RoleID must be (2-5)");
            }
            if (!password.equals(confirm)) {
                flag = false;
                userError.setConfirmError("Hai password khong giong nhau");
            }
            if (flag) {
                /*
                UserDAO dao = new UserDAO();
                boolean check = dao.checkDuplicate(userID);
                if(check){
                    userError.setUserIDError("UserID duplicate");
                    request.setAttribute("ERROR", userError);
                }
                else{
                    UserDTO user = new UserDTO(userID, fullName, roleID, password);
                    dao.insert(user);
                    url = SUCCESS;
                }
                 */
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, fullName, roleID, password);
                dao.insertNew(user);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("UserID duplicate kia");
                request.setAttribute("ERROR", userError);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
