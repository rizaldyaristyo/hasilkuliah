    <!DOCTYPE html>
    <html lang="en">
      <head>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Skydash Admin</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="{{asset('vendors/feather/feather.css')}}" />
        <link rel="stylesheet" href="{{asset('vendors/ti-icons/css/themify-icons.css')}}" />
        <link rel="stylesheet" href="{{asset('vendors/css/vendor.bundle.base.css')}}" />
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel="stylesheet" href="{{asset('vendors/datatables.net-bs4/dataTables.bootstrap4.css')}}" />
        <link rel="stylesheet" href="{{asset('vendors/ti-icons/css/themify-icons.css')}}" />
        <link rel="stylesheet" type="text/css" href="{{asset('js/select.dataTables.min.css')}}" />
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="{{asset('css/vertical-layout-light/style.css')}}" />
        <!-- endinject -->
        <link rel="shortcut icon" href="{{asset('images/favicon.png')}}" />
      </head> 
      <style>
         {box-sizing: border-box;}

          /* Button used to open the contact form - fixed at the bottom of the page */

          /* The popup form - hidden by default */
          .form-popup {
            display: none;
            position: fixed;
            bottom: 0;
            z-index: 100;
            background: white
          }

          /* Add styles to the form container */
          .form-container {
            max-width: 300px;
            padding: 10px;
            background-color: white;
          }

          /* Full-width input fields */
          .form-container input[type=text], .form-container input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #f1f1f1;
          }

          /* Set a style for the submit/login button */
          .form-container .btn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            margin-bottom:10px;
            opacity: 0.8;
          }

          /* Add a red background color to the cancel button */
          .form-container .cancel {
            background-color: red;
          }

      </style>
      <script>
        function openForm(id) {
          document.getElementById(id).style.display = "block";
        }

        function closeForm(id) {
          document.getElementById(id).style.display = "none";
        } 
      </script>
      <body>
        <div class="container-scroller">
          <!-- partial:partials/_navbar.html -->
          <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
            <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
              <a class="navbar-brand brand-logo-mini" href="index.html"><img src="{{asset('images/logo-mini.svg')}}" alt="logo" /></a>
              <a class="navbar-brand brand-logo mr-5" href="index.html"><img src="{{asset('images/logo.svg')}}" class="mr-2" alt="logo" /></a>
            </div>
            <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
              <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                <span class="icon-menu"></span>
              </button>
              <ul class="navbar-nav mr-lg-2">
                <li class="nav-item nav-search d-none d-lg-block">
                  <div class="input-group">
                    <div class="input-group-prepend hover-cursor" id="navbar-search-icon">
                      <span class="input-group-text" id="search">
                        <i class="icon-search"></i>
                      </span>
                    </div>
                    <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now" aria-label="search" aria-describedby="search" />
                  </div>
                </li>
              </ul>
              <ul class="navbar-nav navbar-nav-right">
                <li class="nav-item dropdown">
                  <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
                    <i class="icon-bell mx-0"></i>
                    <span class="count"></span>
                  </a>
                  <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
                    <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
                    <a class="dropdown-item preview-item">
                      <div class="preview-thumbnail">
                        <div class="preview-icon bg-success">
                          <i class="ti-info-alt mx-0"></i>
                        </div>
                      </div>
                      <div class="preview-item-content">
                        <h6 class="preview-subject font-weight-normal">Application Error</h6>
                        <p class="font-weight-light small-text mb-0 text-muted">Just now</p>
                      </div>
                    </a>
                    <a class="dropdown-item preview-item">
                      <div class="preview-thumbnail">
                        <div class="preview-icon bg-warning">
                          <i class="ti-settings mx-0"></i>
                        </div>
                      </div>
                      <div class="preview-item-content">
                        <h6 class="preview-subject font-weight-normal">Settings</h6>
                        <p class="font-weight-light small-text mb-0 text-muted">Private message</p>
                      </div>
                    </a>
                    <a class="dropdown-item preview-item">
                      <div class="preview-thumbnail">
                        <div class="preview-icon bg-info">
                          <i class="ti-user mx-0"></i>
                        </div>
                      </div>
                      <div class="preview-item-content">
                        <h6 class="preview-subject font-weight-normal">New user registration</h6>
                        <p class="font-weight-light small-text mb-0 text-muted">2 days ago</p>
                      </div>
                    </a>
                  </div>
                </li>
                <li class="nav-item nav-profile dropdown">
                  <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
                    <img src="https://picsum.photos/200/200" alt="profile" />
                  </a>
                  <form style="margin-left:2ch" action="{{url('/api/v1/auth/logout')}}" method="post"><input type="submit" value="Logout" /></form>
                  <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
                    <a class="dropdown-item">
                      <i class="ti-settings text-primary"></i>
                      Settingspage-body-wrapper
                    </a>
                    <a class="dropdown-item">
                      <i class="ti-power-off text-primary"></i>
                      Logout
                    </a>
                  </div>
                </li>
                <li class="nav-item nav-settings d-none d-lg-flex">
                  <a class="nav-link" href="#">
                    <i class="icon-ellipsis"></i>
                  </a>
                </li>
              </ul>
              <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                <span class="icon-menu"></span>
              </button>
            </div>
          </nav>
          <!-- partial -->
          <div class="container-fluid page-body-wrapper">
            <!-- partial:partials/_settings-panel.html -->
            <div class="theme-setting-wrapper">
              <div id="theme-settings" class="settings-panel">
                <i class="settings-close ti-close"></i>
                <p class="settings-heading">SIDEBAR SKINS</p>
                <div class="sidebar-bg-options selected" id="sidebar-light-theme">
                  <div class="img-ss rounded-circle bg-light border mr-3"></div>
                  Light
                </div>
                <div class="sidebar-bg-options" id="sidebar-dark-theme">
                  <div class="img-ss rounded-circle bg-dark border mr-3"></div>
                  Dark
                </div>
                <p class="settings-heading mt-2">HEADER SKINS</p>
                <div class="color-tiles mx-0 px-4">
                  <div class="tiles success"></div>
                  <div class="tiles warning"></div>
                  <div class="tiles danger"></div>
                  <div class="tiles info"></div>
                  <div class="tiles dark"></div>
                  <div class="tiles default"></div>
                </div>
              </div>
            </div>
            <div id="right-sidebar" class="settings-panel">
              <i class="settings-close ti-close"></i>
              <ul class="nav nav-tabs border-top" id="setting-panel" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="todo-tab" data-toggle="tab" href="#todo-section" role="tab" aria-controls="todo-section" aria-expanded="true">TO DO LIST</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="chats-tab" data-toggle="tab" href="#chats-section" role="tab" aria-controls="chats-section">CHATS</a>
                </li>
              </ul>
              <div class="tab-content" id="setting-content">
                <div class="tab-pane fade show active scroll-wrapper" id="todo-section" role="tabpanel" aria-labelledby="todo-section">
                  <div class="add-items d-flex px-3 mb-0">
                    <form class="form w-100">
                      <div class="form-group d-flex">
                        <input type="text" class="form-control todo-list-input" placeholder="Add To-do" />
                        <button type="submit" class="add btn btn-primary todo-list-add-btn" id="add-task">Add</button>
                      </div>
                    </form>
                  </div>
                  <div class="list-wrapper px-3">
                    <ul class="d-flex flex-column-reverse todo-list">
                      <li>
                        <div class="form-check">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" />
                            Team review meeting at 3.00 PM
                          </label>
                        </div>
                        <i class="remove ti-close"></i>
                      </li>
                      <li>
                        <div class="form-check">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" />
                            Prepare for presentation
                          </label>
                        </div>
                        <i class="remove ti-close"></i>
                      </li>
                      <li>
                        <div class="form-check">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" />
                            Resolve all the low priority tickets due today
                          </label>
                        </div>
                        <i class="remove ti-close"></i>
                      </li>
                      <li class="completed">
                        <div class="form-check">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" checked />
                            Schedule meeting for next week
                          </label>
                        </div>
                        <i class="remove ti-close"></i>
                      </li>
                      <li class="completed">
                        <div class="form-check">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox" checked />
                            Project review
                          </label>
                        </div>
                        <i class="remove ti-close"></i>
                      </li>
                    </ul>
                  </div>
                  <h4 class="px-3 text-muted mt-5 font-weight-light mb-0">Events</h4>
                  <div class="events pt-4 px-3">
                    <div class="wrapper d-flex mb-2">
                      <i class="ti-control-record text-primary mr-2"></i>
                      <span>Feb 11 2018</span>
                    </div>
                    <p class="mb-0 font-weight-thin text-gray">Creating component page build a js</p>
                    <p class="text-gray mb-0">The total number of sessions</p>
                  </div>
                  <div class="events pt-4 px-3">
                    <div class="wrapper d-flex mb-2">
                      <i class="ti-control-record text-primary mr-2"></i>
                      <span>Feb 7 2018</span>
                    </div>
                    <p class="mb-0 font-weight-thin text-gray">Meeting with Alisa</p>
                    <p class="text-gray mb-0">Call Sarah Graves</p>
                  </div>
                </div>
                <!-- To do section tab ends -->
                <div class="tab-pane fade" id="chats-section" role="tabpanel" aria-labelledby="chats-section">
                  <div class="d-flex align-items-center justify-content-between border-bottom">
                    <p class="settings-heading border-top-0 mb-3 pl-3 pt-0 border-bottom-0 pb-0">Friends</p>
                    <small class="settings-heading border-top-0 mb-3 pt-0 border-bottom-0 pb-0 pr-3 font-weight-normal">See All</small>
                  </div>
                  <ul class="chat-list">
                    <li class="list active">
                      <div class="profile"><img src="images/faces/face1.jpg" alt="image" /><span class="online"></span></div>
                      <div class="info">
                        <p>Thomas Douglas</p>
                        <p>Available</p>
                      </div>
                      <small class="text-muted my-auto">19 min</small>
                    </li>
                    <li class="list">
                      <div class="profile"><img src="images/faces/face2.jpg" alt="image" /><span class="offline"></span></div>
                      <div class="info">
                        <div class="wrapper d-flex">
                          <p>Catherine</p>
                        </div>
                        <p>Away</p>
                      </div>
                      <div class="badge badge-success badge-pill my-auto mx-2">4</div>
                      <small class="text-muted my-auto">23 min</small>
                    </li>
                    <li class="list">
                      <div class="profile"><img src="images/faces/face3.jpg" alt="image" /><span class="online"></span></div>
                      <div class="info">
                        <p>Daniel Russell</p>
                        <p>Available</p>
                      </div>
                      <small class="text-muted my-auto">14 min</small>
                    </li>
                    <li class="list">
                      <div class="profile"><img src="images/faces/face4.jpg" alt="image" /><span class="offline"></span></div>
                      <div class="info">
                        <p>James Richardson</p>
                        <p>Away</p>
                      </div>
                      <small class="text-muted my-auto">2 min</small>
                    </li>
                    <li class="list">
                      <div class="profile"><img src="images/faces/face5.jpg" alt="image" /><span class="online"></span></div>
                      <div class="info">
                        <p>Madeline Kennedy</p>
                        <p>Available</p>
                      </div>
                      <small class="text-muted my-auto">5 min</small>
                    </li>
                    <li class="list">
                      <div class="profile"><img src="images/faces/face6.jpg" alt="image" /><span class="online"></span></div>
                      <div class="info">
                        <p>Sarah Graves</p>
                        <p>Available</p>
                      </div>
                      <small class="text-muted my-auto">47 min</small>
                    </li>
                  </ul>
                </div>
                <!-- chat tab ends -->
              </div>
            </div>
            <!-- partial -->
            <!-- partial:partials/_sidebar.html -->
            <nav class="sidebar sidebar-offcanvas" id="sidebar">
              <ul class="nav">
                <li class="nav-item">
                  <a class="nav-link" href="{{asset('index.html')}}">
                    <i class="icon-grid menu-icon"></i>
                    <span class="menu-title">Dashboard</span>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                    <i class="icon-layout menu-icon"></i>
                    <span class="menu-title">UI Elements</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="ui-basic">
                    <ul class="nav flex-column sub-menu">
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/ui-features/buttons.html')}}">Buttons</a></li>
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/ui-features/dropdowns.html')}}">Dropdowns</a></li>
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/ui-features/typography.html')}}">Typography</a></li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
                    <i class="icon-columns menu-icon"></i>
                    <span class="menu-title">Form elements</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="form-elements">
                    <ul class="nav flex-column sub-menu">
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/forms/basic_elements.html')}}">Basic Elements</a></li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">
                    <i class="icon-bar-graph menu-icon"></i>
                    <span class="menu-title">Charts</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="charts">
                    <ul class="nav flex-column sub-menu">
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/charts/chartjs.html')}}">ChartJs</a></li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#tables" aria-expanded="false" aria-controls="tables">
                    <i class="icon-grid-2 menu-icon"></i>
                    <span class="menu-title">Tables</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="tables">
                    <ul class="nav flex-column sub-menu">
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/tables/basic-table.html')}}">Basic table</a></li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
                    <i class="icon-contract menu-icon"></i>
                    <span class="menu-title">Icons</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="icons">
                    <ul class="nav flex-column sub-menu">
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/icons/mdi.html')}}">Mdi icons</a></li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
                    <i class="icon-head menu-icon"></i>
                    <span class="menu-title">User Pages</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="auth">
                    <ul class="nav flex-column sub-menu">
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/samples/login.html')}}"> Login </a></li>
                      <li class="nav-item"><a class="nav-link" href="{{asset('pages/samples/register.html')}}"> Register </a></li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-toggle="collapse" href="#error" aria-expanded="false" aria-controls="error">
                    <i class="icon-ban menu-icon"></i>
                    <span class="menu-title">Error pages</span>
                    <i class="menu-arrow"></i>
                  </a>
                  <div class="collapse" id="error">
                    <ul class="nav flex-column sub-menu">
                    </ul>
                  </div>
                </li>
              </ul>
            </nav>
            <!-- partial -->
            <div class="main-panel">
              <div class="content-wrapper">
                <div class="row">
                  <div class="col-md-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <div style="text-align: center">
                          <div>
                            <p class="card-title">Tabel Data</p>
                            <p>
                              Data-Data yang ada pada tabel ini adalah data yang telah diinputkan ke dalam database.
                            </p>
                          </div>
                          <div>
                            <h5>API Response:</h5>
                            <iframe name="dummyframe" id="dummyframe" style="display: block;margin-bottom:1rem; width:100%"></iframe>
                          </div>
                          <button onClick="window.location.href=window.location.href" style="margin-bottom: 1rem">Refresh</button>
                        </div>
                        <div class="row">
                          <div class="col-12">
                            <div class="table-responsive">
                              <table id="example" class="display expandable-table" style="width: 100%">
                                <thead>
                                  <tr>
                                    <th>Id#</th>
                                    <th>Image</th>
                                    <th>Title Artikel</th>
                                    <th>Isi</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <?php
                                    use Tymon\JWTAuth\Facades\JWTAuth;
                                    $userid = JWTAuth::parseToken()->authenticate()->id;
                                  ?>
                                  @foreach ($data as $data)
                                  <tr id="data-{{$data['id']}}">
                                    <td>{{$data['id']}}</td>
                                    <td><img style="max-width: 120px" src="{{$data['image']}}" alt="{{$data['image']}}"></td>
                                    <td>{{$data['judul']}}</td>
                                    <td>{{$data['isi_konten']}}</td>
                                    @if($userid != 1)
                                      <td>
                                        {{ Form::open(['url' => '/api/v1/artikels/'.$data['id'], 'method' => 'delete', 'class' => 'deleteForm', 'target'=>'dummyframe']) }}
                                          <input type="submit" class="deleteBtn" value="Delete Data"/>
                                        {{ Form::close() }}
                                      </td>
                                      <td>
                                        <button onclick="openForm('myForm{{$data['id']}}')">Open Edit Menu</button>
                                        <div class="form-popup" id="myForm{{$data['id']}}">
                                          <form action="/api/v1/artikels/{{$data['id']}}" method="POST" target="dummyframe">
                                            @method('patch')
                                            <h1>Edit Data no.{{$data['id']}}</h1>
                                            <h5 style="margin-top: 1rem; width:10ch">Judul</h5>
                                            <input name="judul" type="text" value="{{$data['judul']}}" required>
                                            <h5 style="margin-top: 1rem; width:10ch">URL Gambar</h5>
                                            <input name="image" type="text" value="{{$data['image']}}" required>
                                            <h5 style="margin-top: 1rem; width:10ch">Category ID</h5>
                                            <input name="category_id" type="number" value="{{$data['category_id']}}" id="quantity" name="quantity" min="1" max="1" required>
                                            <h5 style="margin-top: 1rem; width:10ch">Author ID</h5>
                                            <input name="author_id" type="number" value="{{$data['author_id']}}" id="quantity" name="quantity" min="1" max="1" required>
                                            <h5 style="margin-top: 1rem">Cuplikan Konten</h5>
                                            <textarea name="isi_konten" id="" cols="30" rows="10" required>{{$data['isi_konten']}}</textarea> <br>
                                            <input type="submit" value="Update Data" onclick="closeForm('myForm{{$data['id']}}')">
                                          </form>
                                          <button onclick="closeForm('myForm{{$data['id']}}')">Close Edit Menu</button>
                                        </td>
                                        @endif
                                      </tr>
                                      @endforeach
                                </tbody>
                              </table>
                              @if($userid != 1)
                              <div style="margin-top:2rem">
                                <h4>Tambah Data:</h4>
                                <form action="/api/v1/artikels" method="POST" target="dummyframe">
                                  <h5 style="margin-top: 1rem; width:10ch">Judul</h5>
                                  <input type="text" name="judul" required>
                                  <h5 style="margin-top: 1rem">Cuplikan Konten</h5>
                                  <textarea name="isi_konten" id="" cols="30" rows="10" required></textarea> <br>
                                  <h5 style="margin-top: 1rem; width:10ch">Category ID</h5>
                                  <input type="number" name="category_id" id="quantity" name="quantity" min="1" max="1" required>
                                  <h5 style="margin-top: 1rem; width:10ch">Author ID</h5>
                                  <input type="number" name="author_id" id="quantity" name="quantity" min="1" max="1" required>
                                  <h5 style="margin-top: 1rem; width:10ch">URL Gambar</h5>
                                  <input type="text" name="image" required>
                                  <input type="submit" value="Tambah Data">
                                </form>
                              </div>
                              @endif
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- content-wrapper ends -->
              <!-- partial:partials/_footer.html -->
              <footer class="footer">
                <div class="d-sm-flex justify-content-center justify-content-sm-between">
                  <span class="text-muted text-center text-sm-left d-block d-sm-inline-block"
                    >Copyright © 2021. Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash. All rights reserved.</span
                  >
                  <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="ti-heart text-danger ml-1"></i></span>
                </div>
              </footer>
              <!-- partial -->
            </div>
            <!-- main-panel ends -->
          </div>
          <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->

        <!-- plugins:js -->
        <script src="vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="vendors/chart.js/Chart.min.js"></script>
        <script src="vendors/datatables.net/jquery.dataTables.js"></script>
        <script src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
        <script src="js/dataTables.select.min.js"></script>

        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="js/off-canvas.js"></script>
        <script src="js/hoverable-collapse.js"></script>
        <script src="js/template.js"></script>
        <script src="js/settings.js"></script>
        <script src="js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="js/dashboard.js"></script>
        <script src="js/Chart.roundedBarCharts.js"></script>
        <!-- End custom js for this page-->
      </body>
    </html>
