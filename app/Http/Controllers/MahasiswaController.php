<?php

namespace App\Http\Controllers;

use App\Models\Mahasiswa;
use Illuminate\Http\Request;

class MahasiswaController extends Controller {
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        //
    }

    public function getMahasiswaById(Request $request) {
        $mahasiswa = Mahasiswa::find($request->nim);

        return response()->json([
            'success' => true, 
            'message' => 'Berikut adalah detailnya',
            'data' => [
                'mahasiswa' => [
                    'nim' => $mahasiswa->nim,
                    'nama' => $mahasiswa->nama,
                    'angkatan' => $mahasiswa->angkatan,
                    'matakuliah' => $mahasiswa->matakuliah
                ]
            ]
        ]);
    }

    public function getAllMhs(Request $request) {
        $mahasiswa = Mahasiswa::all();

        return response()->json([
            'success' => true, 
            'message' => 'Berikut adalah semua daftar mahasiswa',
            'data' => [
                'mahasiswa' => $mahasiswa
            ]
        ], 200);
    }

    public function addMk(Request $request) {
        $mahasiswa = Mahasiswa::find($request->nim);

        $mahasiswa->matakuliah()->attach($request->mkId);

        return response()->json([
            'success' => true,
            'message' => 'Matakuliah berhasil ditambahkan'
        ]);
    }

    public function deleteMk(Request $request) {
        $mahasiswa = Mahasiswa::find($request->nim);

        $mahasiswa->matakuliah()->detach($request->mkId);

        return response()->json([
            'success' => true,
            'message' => 'Matakuliah berhasil dihapus'
        ]);
    }
}
