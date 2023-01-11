<?php

namespace App\Http\Controllers;

use App\Models\Mahasiswa; // import model User
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class HomeController extends Controller {

    public function home(Request $request) {
        $mahasiswa = $request->mahasiswa;

        return response()->json([
            'status' => 'Success',
            'message' => 'selamat datang ' . $mahasiswa->nama,
        ],200);
    }
}