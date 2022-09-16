import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/models/admin/admin';
import { AdminService } from 'src/app/services/admin/admin.service';

@Component({
  selector: 'app-admin-edit',
  templateUrl: './admin-edit.component.html',
  styleUrls: ['./admin-edit.component.css']
})
export class AdminEditComponent implements OnInit {
  admin: Admin
  constructor(
    private ar: ActivatedRoute,
    private adminService: AdminService,
    private router: Router
  ) {
    this.admin = new Admin();
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.adminService.getById(params['id']).subscribe((result) => {
          this.admin = result;
        });
      }
    });
  }
  save() {

    if (this.admin.id) {
      this.adminService.update(this.admin).subscribe((result) => {
        this.router.navigateByUrl('/admin');
      });
    } else {
      this.adminService.create(this.admin).subscribe((result) => {
        this.router.navigateByUrl('/admin');
      });
    }
  }

}
