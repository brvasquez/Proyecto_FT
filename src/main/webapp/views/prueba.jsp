<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">

    <!--Estilo Iconos MATERIAL ICONS-->
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
</head>
<body>
<div class="container">
        <aside>
            <div class="top">
                <div class="logo">
                    <img src="./images/logo.png" alt="">
                    <h2>Frienly <span class="primary"> Tutor</span> </h2>
                </div>
                <div class="close" id="close-btn">
                    <span class="material-icons-sharp"> close</span>
                </div>
            </div>

            <div class="sidebar">
                <a href="#">
                    <span class="material-icons-sharp">dashboard</span>
                    <h3>Menu</h3>
                </a>
                <a href="#" class="active">
                    <span class="material-icons-sharp">person_outline</span>
                    <h3>Proveedores</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">receipt_long</span>
                    <h3>Ordenes</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">insights</span>
                    <h3>Analisis</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">mail_outline</span>
                    <h3>Mensajes</h3>
                    <span class="message-count">26</span>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Productos</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">report_gmailerrorred</span>
                    <h3>Reportes</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">settings</span>
                    <h3>Configuracion</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">add</span>
                    <h3>Añadir Producto</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">logout</span>
                    <h3>Cerrar Sesion</h3>
                </a>
            </div>
        </aside>
        <!----------------------AQUI ACABA EL MENU ------------>
        <main>
            <h1>Tablero de Mandos</h1>
            <div class="date">
                <input type="date">
            </div>

            <div class="insights">
                <div class="sales">
                    <span class="material-icons-sharp">analytics</span>
                    <div class="middle">
                        <div class="left">
                            <h3>Total ventas</h3>
                            <h1>$25,234</h1>
                        </div>
                        <div class="progress">
                            <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                            </svg>
                            <div class="number">
                                <p> 81%</p>
                            </div>
                        </div>
                    </div>
                    <small class="text-muted">despues de 34 horas</small>
                </div>
                <!--FINALIZA SALES-->
                <div class="expenses">
                    <span class="material-icons-sharp">bar_chart</span>
                    <div class="middle">
                        <div class="left">
                            <h3>Total Expenses</h3>
                            <h1>$12,234</h1>
                        </div>
                        <div class="progress">
                            <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                            </svg>
                            <div class="number">
                                <p> 61%</p>
                            </div>
                        </div>
                    </div>
                    <small class="text-muted">despues de 34 horas</small>
                </div>
                <!--FINALIZA SALES-->
                <div class="income">
                    <span class="material-icons-sharp">stacked_line_chart</span>
                    <div class="middle">
                        <div class="left">
                            <h3>Total</h3>
                            <h1>$33,234</h1>
                        </div>
                        <div class="progress">
                            <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                            </svg>
                            <div class="number">
                                <p> 11%</p>
                            </div>
                        </div>
                    </div>
                    <small class="text-muted">despues de 34 horas</small>
                </div>
                <!--FINALIZA SALES-->
            </div>
            <!--FINALIZA CARDS-->

            <div class="recent-orders">
                <h2>Ordenes Recientes</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Nombre del Producto</th>
                            <th>Nombre del Producto</th>
                            <th>Nombre del Producto</th>
                            <th>Nombre del Producto</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Mni Drone</td>
                            <td>23232</td>
                            <td>Duo</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Detalles</td>
                        </tr>
                        <tr>
                            <td>Mni Drone</td>
                            <td>23232</td>
                            <td>Duo</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Detalles</td>
                        </tr>
                        <tr>
                            <td>Mni Drone</td>
                            <td>23232</td>
                            <td>Duo</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Detalles</td>
                        </tr>
                        <tr>
                            <td>Mni Drone</td>
                            <td>23232</td>
                            <td>Duo</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Detalles</td>
                        </tr>
                        <tr>
                            <td>Mni Drone</td>
                            <td>23232</td>
                            <td>Duo</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Detalles</td>
                        </tr>
                    </tbody>
                </table>
                <a href="#">Show All</a>
            </div>
        </main>
        <!--FINALIZA EL MAIN-->

        <div class="right">
            <div class="top">
                <button id="menu-btn">
                    <span class="material-icons-sharp"> menu</span>
                </button>
                <div class="theme-toggler">
                    <span class="material-icons-sharp active">light_mode</span>
                    <span class="material-icons-sharp">dark_mode</span>
                </div>
                <div class="profile">
                    <div class="info">
                        <p>hola, <b>Mikasa</b></p>
                        <small class="text-muted">Admin</small>
                    </div>
                    <div class="profile-photo">
                        <img src="./images/mikasa.jpg">
                    </div>
                </div>
            </div>
            <!--FINALIZA EL TOP-->
            <div class="recent-updates">
                <h2>Actualizaciones</h2>
                <div class="updates">
                    <div class="update">
                        <div class="profile-photo">
                            <img src="./images/mikasa.jpg">
                        </div>
                        <div class="message">
                            <p><b>Mikasa</b> reciedsjds es un nuebo libr
                                no se que mas poner xd</p>
                            <small class="text-muted">2 minutes Ago</small>
                        </div>
                    </div>
                    <div class="update">
                        <div class="profile-photo">
                            <img src="./images/mikasa.jpg">
                        </div>
                        <div class="message">
                            <p><b>Mikasa </b> reciedsjds es un nuebo libr
                                no se que mas poner xd</p>
                            <small class="text-muted">2 minutes Ago</small>
                        </div>
                    </div>
                    <div class="update">
                        <div class="profile-photo">
                            <img src="./images/mikasa.jpg">
                        </div>
                        <div class="message">
                            <p><b>Mikasa </b> reciedsjds es un nuevo libr
                                no se que mas poner xd</p>
                            <small class="text-muted">2 minutes Ago</small>
                        </div>
                    </div>
                </div>
            </div>
            <!--FINALIZA RECENT UPDATES-->  
            <div class="sales-analytics">
                <h2>Analisis</h2>
                <div class="item online">
                    <div class="icon">
                        <span class="material-icons-sharp">shopping_cart</span>
                     </div>
                     <div class="right">
                        <div class="info">
                            <h3> Online ordenes</h3>
                            <small class="text-muted"> hace 24 horas</small>
                        </div>
                        <h5 class="success">+39%</h5>
                        <h3>3849</h3>
                     </div>
                </div>
                <div class="item offline">
                    <div class="icon">
                        <span class="material-icons-sharp">local_mall</span>
                     </div>
                     <div class="right">
                        <div class="info">
                            <h3> ofline ordenes</h3>
                            <small class="text-muted"> hace 24 horas</small>
                        </div>
                        <h5 class="danger">-19%</h5>
                        <h3>1100</h3>
                     </div>
                </div>
                <div class="item customers">
                    <div class="icon">
                        <span class="material-icons-sharp">person</span>
                     </div>
                     <div class="right">
                        <div class="info">
                            <h3> Nuevos Proveedores</h3>
                            <small class="text-muted"> hace 24 horas</small>
                        </div>
                        <h5 class="success">+25%</h5>
                        <h3>333</h3>
                     </div>
                </div>
                <div class="item add-product">
                    <div>
                        <span class="material-icons-sharp">add</span>
                        <h3>Nuevo Producto</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="index.js"></script>
</body>
</html>