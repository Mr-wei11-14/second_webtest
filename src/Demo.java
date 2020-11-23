import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Demo")
public class Demo extends HttpServlet {
    public boolean judge(String phone_num) {
        //dd-dddd-dddd长度为13
        if (phone_num.length() != 13)   return false;
        for (int i = 0; i < phone_num.length(); i++) {
            if (i == 3 || i == 8) { //符号位'-'
                if (phone_num.charAt(i) != '-') {
                    return false;
                }
            }
            else {
                //d为0-9的数字
                if (phone_num.charAt(i) < '0' || phone_num.charAt(i) > '9') {
                    return  false;
                }
            }
        }
        return true;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = gb2312");
        PrintWriter out = response.getWriter();
        //获取表单信息
        String admin = request.getParameter("admin");
        String Email = request.getParameter("Email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        out.println("<h1>表单提交信息如下：</h1><hr/>");
        out.println("用户名：" + admin + "<br/>");
        out.println("Email：" + Email + "<br/>");
        out.println("通信地址：" + address + "<br/>");
        if (!judge(phone_number)) { //如果电话号码格式有误
            out.println("电话号码格式错误，请检查重新输入" + "<br/>");
        }
        else {
            out.println("电话号码：" + phone_number + "<br/>");
        }
    }
}
