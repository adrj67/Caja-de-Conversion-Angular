import { Component, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CalculatorService } from '../../service/calculator.service';
import { CommonModule } from '@angular/common';

//interfaz para los resultados
interface ResultadoCalculado {
  beneficioReal: number;
  poderPublico: number;
  rescateMayorPago: boolean;
  iFichasPremiadas: number;
  iFichasAPagar: number;
  eFichasPremiadas: number;
  eFichasAPagar: number;
}

@Component({
  selector: 'app-input-form',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './input-form.component.html',
  styleUrl: './input-form.component.css'
})

export class InputFormComponent {
  formulario: FormGroup;
  resultadoBeneficioReal: number | null = null;  // Almacenar el resultado del beneficio real
  resultadoPoderPublico: number | null = null;   // Almacenar el resultado del poder público
  rescateMayorPago: boolean = false;

  //@Output() resultadoCalculado = new EventEmitter<{ beneficioReal: number, poderPublico: number, rescateMayorPago: boolean }>();  // Emitir ambos resultados
  @Output() resultadoCalculado = new EventEmitter<ResultadoCalculado>();

  constructor(private fb: FormBuilder, private calculator: CalculatorService) {
    this.formulario = this.fb.group({
      beneficio: [null],
      quebranto: [null],
      ventaDeFichas: [null],
      pagadasPorCajaPublico: [null],
      provenientesCajaEmpleados: [null],
      fichasDelCargo: [null],
      devolucionFueraDelCargo: [null]
    });
  }

  calcularResultados() {
    const { beneficio, quebranto, ventaDeFichas, pagadasPorCajaPublico, provenientesCajaEmpleados, fichasDelCargo, devolucionFueraDelCargo } = this.formulario.value;
  
    const beneficioNum = +beneficio || 0;
    const quebrantoNum = +quebranto || 0;
    const ventaDeFichasNum = +ventaDeFichas || 0;
    const pagadasPorCajaPublicoNum = +pagadasPorCajaPublico || 0;
    const provenientesCajaEmpleadosNum = +provenientesCajaEmpleados || 0;
    const fichasDelCargoNum = +fichasDelCargo || 0;
    const devolucionFueraDelCargoNum = +devolucionFueraDelCargo || 0;
  
    const resultadoBeneficioReal = this.calculator.beneficioRealService(beneficioNum, quebrantoNum);
    const resultadoPoderPublico = this.calculator.poderPublicoServicio(ventaDeFichasNum, pagadasPorCajaPublicoNum, provenientesCajaEmpleadosNum, resultadoBeneficioReal, fichasDelCargoNum, devolucionFueraDelCargoNum);
    const rescateMayorPago = this.calculator.rescateMayorPagoService(pagadasPorCajaPublicoNum, resultadoPoderPublico);
  
    const calculosNormales = this.calculator.calculoNormalService(rescateMayorPago, resultadoPoderPublico, devolucionFueraDelCargoNum, pagadasPorCajaPublicoNum);
  
    this.resultadoCalculado.emit({
      beneficioReal: resultadoBeneficioReal,
      poderPublico: resultadoPoderPublico,
      rescateMayorPago: rescateMayorPago,
      iFichasPremiadas: calculosNormales.iFichasPremiadas,
      iFichasAPagar: calculosNormales.iFichasAPagar,
      eFichasPremiadas: calculosNormales.eFichasPremiadas,
      eFichasAPagar: calculosNormales.eFichasAPagar
    });
  }
  
}