import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { IndexComponent } from './index/index.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
    {path: "user", component: UserComponent, canActivate: [AuthGuard], data:{roles: ['USER']}},
    {path: "admin", component: AdminComponent, canActivate: [AuthGuard], data:{roles: ['ADMIN']}},
    {path: "index", component: IndexComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
