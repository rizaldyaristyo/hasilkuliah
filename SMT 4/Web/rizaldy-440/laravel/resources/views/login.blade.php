@extends('layouts.master')
@section('title', 'Home')
@section('content')
<style>
    .jarak input{
        margin-top: 0px
    }
</style>
    <div>
        @if ($data == 'register-success')
            <div class="alert alert-success">
                <script>alert('Registration Success')</script>
            </div>
        @elseif ($data == 'register-failed')
            <div class="alert alert-danger">
                <script>alert('Registration Failed')</script>
            </div>
        @elseif ($data == 'login-failed')
            <div class="alert alert-danger">
                <script>alert('Login Failed')</script>
            </div>
        @endif
    </div>
    <div style="margin-top:0rem;height: 50vh;weight: 50vw;display:flex;justify-content: center;align-items:center" class="jarak alignCenter2">
        <div class="jarak">
            <h1>Login</h1>
            <form action="{{url('/api/v1/auth/login')}}" method="post">
            <input type="text" name="email" placeholder="E-Mail" required /> <br>
            <input type="password" name="password" placeholder="Password" required /> <br>
            <input type="submit" value="LOGIN">
            </form>
        </div>
        <div>
            <h1 style="margin-top: 100px;margin-right: 50px;margin-left: 50px;">
                 - OR -
            </h1>
        </div>
        <div class="jarak">
            <h1>Register</h1>
            <form action="{{url('/api/v1/auth/register')}}" method="post">
            <input type="text" placeholder="Name" name="name" required /> <br>
            <input type="text" placeholder="E-Mail" name="email" required /> <br>
            <input type="password" placeholder="Password" name="password" required /> <br>
            <input type="password" placeholder="Confirm Password" name="password_confirmation" required /> <br>
            <input type="submit" value="SIGNUP">
            </form>
        </div>
        <div>
            <h1 style="margin-top: 100px;margin-right: 50px;margin-left: 50px;">
                 - OR -
            </h1>
        </div>
        <div style="margin-top: 30px;">
            <form action="{{url('/api/v1/auth/login')}}" method="post"  >
                <input type="hidden" name="email" value="guest" readonly /> <br>
                <input type="hidden" name="password" value="guest" readonly /> <br>
                <input type="submit" name="token" value="Login as Guest" />
            </form>
        </div>
    </div>
@endsection