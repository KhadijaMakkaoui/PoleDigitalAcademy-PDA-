<%
	if(session.getAttribute("login")==null){
		response.sendRedirect("login.jsp");
	}
%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.stream.Collectors"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="entity.Responsable"%>
<%@ page import="service.implementation.responsableServiceImp"%>

<%@ page import="entity.Participant"%>
<%@ page import="service.implementation.participantServiceImp"%>

<%@ page import="entity.Activite"%>
<%@ page import="service.implementation.activiteServiceImp"%>

<%@ page import="entity.Exercice"%>
<%@ page import="service.implementation.exerciceServiceImp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="home.jsp" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>DASHMIN</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0"><%= session.getAttribute("login") %></h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="home.jsp" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                    <a href="responsable.jsp" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Responsable</a>
                    <a href="participant.jsp" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Participant</a>
                    <a href="activite.jsp" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Activite</a>
                    <a href="exercice.jsp" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>Exercice</a>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                <a href="home.jsp" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item dropdown">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <span class="d-none d-lg-inline-flex"><%= session.getAttribute("login") %></span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="logout" class="dropdown-item">Log Out</a>
                            </div>
                        </div>
                    </div>
            </nav>
            <!-- Navbar End -->


            <!-- Sale & Revenue Start -->
            <%
			responsableServiceImp re = new responsableServiceImp();
            participantServiceImp pa = new participantServiceImp();
			activiteServiceImp ac = new activiteServiceImp();
			exerciceServiceImp ex = new exerciceServiceImp();
			
			int numre = re.getAll().size();
			int numpa = pa.getAll().size();
			int numac = ac.getAll().size();
			int numex = ex.getAll().size();
			%>
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-user-tie fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Responsable</p>
                                <h6 class="mb-0"><%= numre %></h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-users fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Participant</p>
                                <h6 class="mb-0"><%= numpa %></h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-thumbtack fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Activite</p>
                                <h6 class="mb-0"><%= numac %></h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-icons fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Exercice</p>
                                <h6 class="mb-0"><%= numex %></h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Sale & Revenue End -->





            <!-- Recent Sales Start -->
             <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Derniers Responsables Ajoutes</h6>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                            <tr class="text-dark">
                                <th scope="col">Nom</th>
                                <th scope="col">Prenom</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Domaine</th>
                                <th scope="col">Etat</th>
                                <th scope="col">Role</th>
                                <th scope="col">Type</th>
                            </tr>
                            </thead>
                            <tbody>
							<%
					    	List<Responsable> relist = null;
							
							relist = re.getAll().stream().limit(3).collect(Collectors.toList());
							for(Responsable responsable : relist) {
							%>
                            <tr class="item">
								<td class="d-none"><%=  responsable.getId_user() %></td>
                                <td><%=  responsable.getNom() %></td>
                                <td><%=  responsable.getPrenom() %></td>
                                <td><%=  responsable.getPhone() %></td>
                                <td><%=  responsable.getDomaine() %></td>
                                <td><%=  responsable.getEtat() %></td>
                                <td><%=  responsable.getType() %></td>
                                <td><%=  responsable.getRole() %></td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Derniers Participants Ajoutes</h6>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                            <tr class="text-dark">
                                <th scope="col">Nom</th>
                                <th scope="col">Prenom</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Domaine</th>
                                <th scope="col">Structure</th>
                                <th scope="col">Role</th>                            </tr>
                            </thead>
                            <tbody>
							<%
					    	List<Participant> palist = null;
							
							palist = pa.getAll().stream().limit(3).collect(Collectors.toList());
							int num = palist.size();
							for(Participant participant : palist) {
							%>
                            <tr class="item">
								<td class="d-none"><%=  participant.getId_user() %></td>
                                <td><%=  participant.getNom() %></td>
                                <td><%=  participant.getPrenom() %></td>
                                <td><%=  participant.getEmail() %></td>
                                <td><%=  participant.getPhone() %></td>
                                <td><%=  participant.getDomaine() %></td>
                                <td><%=  participant.getStructure() %></td>
                                <td><%=  participant.getRole() %></td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Dernieres Activites Ajoutees</h6>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                            <tr class="text-dark">
                                <th scope="col">Titre</th>
                                <th scope="col">Type</th>
								<th scope="col">Date Debut</th>
                                <th scope="col">Date Fin</th>
                                <th scope="col">Descriptif</th>
                                <th scope="col">Etat</th>
                            </tr>
                            </thead>
                            <tbody>
							<%
					    	List<Activite> aclist = null;
							
							aclist = ac.getAll().stream().limit(3).collect(Collectors.toList());
							for(Activite activite : aclist) {
							%>
                            <tr class="item">
								<td class="d-none"><%=  activite.getId_activite() %></td>
                                <td><%=  activite.getTitre() %></td>
                                <td><%=  activite.getType() %></td>
                                <td><%=  activite.getDate_debut() %></td>
                                <td><%=  activite.getDate_fin() %></td>
                                <td><%=  activite.getDescriptif() %></td>
                                <td><%=  activite.getEtat() %></td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Derniers Exercies Ajoutes</h6>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                            <tr class="text-dark">
                                <th scope="col">Annee</th>
                                <th scope="col">Date Debut</th>
                                <th scope="col">Date Fin</th>
                                <th scope="col">Status</th>
                            </tr>
                            </thead>
                            <tbody>
							<%
					    	List<Exercice> exlist = null;
							
							exlist = ex.getAll().stream().limit(3).collect(Collectors.toList());
							for(Exercice exercice : exlist) {
							%>
                            <tr class="item">
								<td class="d-none"><%=  exercice.getId_exercice() %></td>
                                <td><%=  exercice.getAnnee() %></td>
                                <td><%=  exercice.getDate_debut() %></td>
                                <td><%=  exercice.getDate_fin() %></td>
                                <td><%=  exercice.getStatus() %></td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->
            <!-- Content End -->


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
            </div>

            <!-- JavaScript Libraries -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="lib/chart/chart.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>
            <script src="lib/tempusdominus/js/moment.min.js"></script>
            <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
            <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
</body>

</html>