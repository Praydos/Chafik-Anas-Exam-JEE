// src/app/components/client-form/client-form.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService, ClientDTO } from '../../services/client.service';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css'],
})
export class ClientFormComponent {
  client: ClientDTO = {
    name: '',
    email: '',
    phoneNumber: '',
  };

  constructor(private clientService: ClientService, private router: Router) {}

  saveClient(): void {
    this.clientService.saveClient(this.client).subscribe(() => {
      this.router.navigate(['/clients']);
    });
  }
}
