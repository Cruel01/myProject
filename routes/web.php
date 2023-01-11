<?php

/** @var \Laravel\Lumen\Routing\Router $router */

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return $router->app->version();
});

$router->group(['prefix' => 'auth'], function () use ($router) {
    $router->post('/register', ['uses'=> 'AuthController@register']);
    $router->post('/login', ['uses'=> 'AuthController@login']);
});

$router->group(['prefix' => 'mahasiswa'], function () use ($router) {
    $router->get('/', ['uses'=> 'MahasiswaController@getAllMhs']);
    $router->get('/{nim}', ['uses' => 'MahasiswaController@getMahasiswaById']);
    $router->post('/{nim}/mk/{mkId}', ['uses' => 'MahasiswaController@addMk']);
    $router->put('/{nim}/mk/{mkId}', ['uses' => 'MahasiswaController@deleteMk']);
});

$router->group(['prefix' => 'mk'], function () use ($router) {
    $router->post('/', ['uses' => 'MatakuliahController@createMk']);
    $router->get('/', ['uses' =>'MatakuliahController@getAllMk']);
});

$router->get('/home', ['middleware' => 'jwt.auth', 'uses' => 'HomeController@home']);


$router->get('/', ['uses' => 'HomeController@index']);
$router->get('/hello', ['uses' => 'HomeController@hello']);
