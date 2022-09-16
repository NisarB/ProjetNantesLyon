import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/models/admin/admin';
import { Utilisateur } from 'src/app/models/utilisateur';
import { AdminService } from 'src/app/services/admin/admin.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {
  admins: Admin[] = [];
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.adminService.getAll().subscribe((result) => {
      this.admins = result;
    });
  }
  delete(id: number) {
    this.adminService.deleteById(id).subscribe(() => {
      this.list()
    });
  }


}
