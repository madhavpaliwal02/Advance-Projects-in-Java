<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>


<%
    Thread.sleep(300);
    PostDao dao = new PostDao(ConnectionProvider.getCon());

    int cid = Integer.parseInt(request.getParameter("cid"));

    List<Posts> post = null;

    if (cid == 0) {
        post = dao.getAllPosts();
    } else {
        post = dao.getPostByCatId(cid);
    }

    if (post.size() == 0) {
        out.println("<h3 class='display-3 text-center'> No posts yet in this category...!!! </h3>");
        return;
    }

    for (Posts p : post) {
%>

<div class="col-md-6 mt-2">
    <div class="card">

        <div class="card-body">
            <img class="card-img-top" src="blog_pics/<%= p.getpPic()%>" alt="Card image cap">
            <b> <%= p.getpTitle()%> </b>
            <p> <%= p.getpContent()%> </p>
            <!--<pre> <%= p.getpCode()%> </pre>-->
        </div>

        <div class="card-footer text-center">
            <a href="#!" class="btn btn-outline-primary btn-sm">
                <i class="fa fa-thumbs-o-up"></i>   <span>10</span>
            </a>
            <a href="show_Blog_Post.jsp?post_id=<%= p.getpId() %>" class="btn btn-outline-primary btn-sm">Read More...</a>
            <a href="#!" class="btn btn-outline-primary btn-sm">
                <i class="fa fa-commenting-o"></i>   <span>20</span>
            </a>
        </div>
    </div>
</div>

<%
    }
%>