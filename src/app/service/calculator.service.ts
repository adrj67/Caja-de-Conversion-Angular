import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor() { }

  beneficioRealService(beneficio: number, quebranto: number): number {
    return beneficio - quebranto; 
  }

  poderPublicoServicio(ventaDeFichas: number, pagadasPorCajaPublico: number, provenientesCajaEmpleados: number,
    resultadoBeneficioReal: number, fichasDelCargo: number, devolucionFueraDelCargo: number): number {
      return ventaDeFichas - (pagadasPorCajaPublico + provenientesCajaEmpleados) - resultadoBeneficioReal - fichasDelCargo + devolucionFueraDelCargo;
  }

  rescateMayorPagoService(pagadasPorCajaPublico: number, poderPublico: number): boolean {
    return pagadasPorCajaPublico < (poderPublico * -1);
  }

  calculoNormalService(rescateMayorPago: boolean, poderPublico: number, devolucionFueraDelCargo: number, pagadasPorCajaPublico:number ){

  /* convertir todos los valores a numéricos
  const poderPublicoNum = +poderPublico || 0;
  const devolucionFueraDelCargoNum = +devolucionFueraDelCargo || 0;
  const pagadasPorCajaPublicoNum = +pagadasPorCajaPublico || 0;*/

  let iFichasPremiadas: number;
  let iFichasAPagar: number;
  let eFichasPremiadas: number;
  let eFichasAPagar: number;

    if(rescateMayorPago){
      iFichasPremiadas = (poderPublico * -1) + devolucionFueraDelCargo;
      iFichasAPagar = pagadasPorCajaPublico;
      eFichasPremiadas = pagadasPorCajaPublico;
      eFichasAPagar = pagadasPorCajaPublico + (poderPublico * -1) + devolucionFueraDelCargo;

    } else {
      iFichasPremiadas = 0;
      iFichasAPagar = pagadasPorCajaPublico + poderPublico - devolucionFueraDelCargo;
      eFichasPremiadas = pagadasPorCajaPublico + poderPublico - devolucionFueraDelCargo;
      eFichasAPagar = pagadasPorCajaPublico;
    }

    return {
      iFichasPremiadas,
      iFichasAPagar,
      eFichasPremiadas,
      eFichasAPagar,
    };
  }

}
