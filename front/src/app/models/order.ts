export interface Order {
    id?: number;
    userId: number;
    productId: number;
    isPaid: Boolean;
    isApproved: Boolean;
    quantity: number;
}
