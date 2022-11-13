<%
	if(session.getAttribute("login")==null){
		response.sendRedirect("login.jsp");
	}
%>
<%@ page import="java.util.List"%>
<%@ page import="entity.Activite"%>
<%@ page import="service.implementation.activiteServiceImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>PDA</title>
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
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>PDA</h3>
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
                    <a href="home.jsp" class="nav-item nav-link "><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                    <a href="responsable.jsp" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Responsable</a>
                    <a href="participant.jsp" class="nav-item nav-link "><i class="fa fa-keyboard me-2"></i>Participant</a>
                    <a href="activite.jsp" class="nav-item nav-link active"><i class="fa fa-table me-2"></i>Activite</a>
                    <a href="exercice.jsp" class="nav-item nav-link "><i class="fa fa-chart-bar me-2"></i>Exercice</a>
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
                                <a href="#" class="dropdown-item">Log Out</a>
                            </div>
                        </div>
                    </div>
            </nav>
            <!-- Navbar End -->


            <!-- Chart Start -->
            <!-- Modal addupdate-->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div id="addupdate">
										    <form method="post" action="activite" class="bg-light rounded h-100 p-4">
										        <h6 class="mb-4">Nouvelle activite</h6>
										        <div class="form-floating mb-3 d-none">
										            <input type="text" class="id form-control" name="id" id="" value="0">
										        </div>
										        <div class="form-floating mb-3">
										            <input type="text" class="titre form-control" id="titre"
										                   placeholder="Titre" name="titre" value="">
										            <label for="titre">Titre</label>
										        </div>
										        <div class="form-floating mb-3">
										            <select class="type form-select" id="type"
										                    aria-label="Floating label select example" name="type">
										                <option selected value="FORMATION">Formation</option>
										                <option value="TALK">Talk</option>
										                <option value="EVENEMENT">Evenement</option>
										            </select>
										            <label for="type">Type</label>
										        </div>
										        <div class="form-floating mb-3">
										            <input type="date" class="form-control" name="dateDebut" id="dateDebut"
										                   >
										            <label class="dated" for="dateDebut">Date debut</label>
										        </div>
										        <div class="form-floating mb-3">
										            <input type="date" class="form-control" name="dateFin" id="dateFin"
										            >
										            <label class="datef" for="dateFin">Date fin</label>
										        </div>
										        <div class="form-floating mb-3">
										            <input type="text" class="descriptif form-control" id="descriptif"
										                   placeholder="Descriptif" name="descriptif" value="">
										            <label for="descriptif">Descriptif</label>
										        </div>
										        <div class="form-floating mb-3">
										            <select class="etat form-select" id="etat"
										                    aria-label="Floating label select example" name="etat">
										                <option selected value="ACTIVE">Active</option>
										                <option value="DESACTIVE">Desactive</option>
										            </select>
										            <label for="etat">Etat</label>
										        </div>
										        <div class="mx-auto w-50">
										            <button type="submit" class="btn btn-primary py-3  mb-4 w-100">Ajouter/Modifier</button>
										        </div>
										    </form>
										</div> 
                                    </div>
                                </div>
                            </div>
			<!-- Modal addupdate End-->
            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Activites</h6>
                        <a href="#addupdate" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">Nouvelle activite</a>
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
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>
							<%
							activiteServiceImp ac = new activiteServiceImp();
					    	List<Activite> aclist = null;
							
							aclist = ac.getAll();
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
                                <td><a class="addupdate btn btn-sm btn-primary mx-1" href="#addupdate" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">Modifier</a><a class="btn btn-sm btn-primary mx-1" href="acdelete?id=<%=activite.getId_activite()%>">Supprimer</a></td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script type="text/javascript">
    document.querySelectorAll('.addupdate').forEach(function(btn) {
        btn.addEventListener('click', function(e) {
            let item = e.target.closest('.item');
            let children = item.children;

            let id = children[0].textContent;
            let titre = children[1].textContent;
            let type = children[2].textContent;
            let dated = children[3].textContent;
            let datef = children[4].textContent;
            let descriptif = children[5].textContent;
            let etat = children[6].textContent;

            document.querySelector('#addupdate .id').value = id;
            document.querySelector('#addupdate .titre').value = titre;
            document.querySelector('#addupdate .type').value = type;
            document.querySelector('#addupdate .dated').textContent = dated;
            document.querySelector('#addupdate .datef').textContent = datef;
            document.querySelector('#addupdate .descriptif').value = descriptif;
            document.querySelector('#addupdate .etat').value = etat;

        })
    })
    </script>
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