export interface Order {
    id?: number;
    userId: number;
    productId: number;
    paid: Boolean;
    quantity: number;
}
