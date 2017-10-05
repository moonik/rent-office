import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {HttpClient} from "./common/services/http-client.service";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {AppComponent} from "./app.component";
import {FormsModule} from '@angular/forms';
import {HomeService} from './home/home.service';
import {DetailsComponent} from './details/details.component';
import {DetailsService} from './details/details.service';
import {DetailsDto} from './details/detailsDto';
import {HomeDto} from './home/homeDto';
import {AlertComponent} from './alert/alert.component';
import {AlertService} from './alert/alert.service';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: ':action/:id/:date', component: DetailsComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes
    ),
    FormsModule 
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    DetailsComponent,
    AlertComponent
  ],
  providers: [HttpClient, HomeService, DetailsService, DetailsDto, HomeDto, AlertService],
  bootstrap: [AppComponent]

})
export class AppModule {
}
