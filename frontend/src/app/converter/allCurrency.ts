export interface Rate {
    currency: string;
    code: string;
    mid: number;
}

export interface AllCurrency {
    rates: Rate[];
    base: string;
    effectiveDate: string;
}